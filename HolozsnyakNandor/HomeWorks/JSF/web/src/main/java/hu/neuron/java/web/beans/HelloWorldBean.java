package hu.neuron.java.web.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

@ManagedBean
@SessionScoped
public class HelloWorldBean implements Serializable {
	Logger logger = Logger.getLogger(HelloWorldBean.class);
	private String message = "Hello World!";

	@PostConstruct
	public void init() {
		try {
			logger.debug("HelloWorldBean init !");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
