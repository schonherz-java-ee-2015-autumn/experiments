package hu.neuron.java.web.beans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hu.neuron.java.service.UserServiceLocal;
import hu.neuron.java.service.vo.RoleVO;
import hu.neuron.java.service.vo.UserVO;

@Service("customUserDetailsService")
@EJB(name = "ejb.UserServiceLocal", beanInterface = UserServiceLocal.class)
public class CustomUserDetailsService implements UserDetailsService {

	@EJB
	UserServiceLocal userService;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		UserVO user;
		try {
			user = userService.findUserByName(username);

			if (user == null) {
				throw new UsernameNotFoundException(username);
			}
			List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());

			return buildUserForAuthentication(user, authorities);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException(e.getMessage());
		}

	}

	private User buildUserForAuthentication(UserVO user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(List<RoleVO> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		for (RoleVO userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}
}