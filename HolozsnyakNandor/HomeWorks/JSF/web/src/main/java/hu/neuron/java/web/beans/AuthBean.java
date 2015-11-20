package hu.neuron.java.web.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean
@SessionScoped
public class AuthBean implements Serializable {
	public static Authentication auth;
	public static String getUser() {
		auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}
}
