package hu.neuron.java.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import hu.neuron.java.service.vo.RoleVO;
import hu.schonherz.java.dao.UserDao;
import hu.schonherz.java.entities.Role;
import hu.schonherz.java.entities.User;

@Transactional(readOnly = true)
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserDao userDAO;

	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		System.out.println("Trying to log in " + login);
		User domainUser = userDAO.findByUsername(login);
		System.out.println("Got Domain User " + domainUser.getUsername());

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		System.out.println("Making UserDetail user....");

		/*UserDetails user = new org.springframework.security.core.userdetails.User(domainUser.getUsername(),
				domainUser.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
				getAuthorities(domainUser.getRoles().get(0).getId().intValue()));*/

		List<GrantedAuthority> authorities = buildUserAuthority(domainUser.getRoles());
		for(GrantedAuthority g: authorities) {
			System.out.println("AUTH:" + g.getAuthority());
		}
		//System.out.println("Role: " + domainUser.getRoles().get(0).getId().intValue());
		//System.out.println(getAuthorities(1).toString());
		//System.out.println("Got user " + domainUser.getUsername() + " with " + user.getAuthorities().size());
		return buildUserForAuthentication(domainUser, authorities);
	}

	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}

	public List<String> getRoles(Integer role) {

		List<String> roles = new ArrayList<String>();

		// if (role.intValue() == 1) {
		// roles.add("ROLE_MODERATOR");
		// roles.add("ROLE_ADMIN");
		// } else if (role.intValue() == 2) {
		// roles.add("ROLE_MODERATOR");
		// }
		if (role.intValue() == 1) {
			roles.add("USER_ROLE");
		}
		return roles;
	}

	private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildUserAuthority(List<Role> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		for (Role userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
				setAuths);

		return Result;
	}
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

}
