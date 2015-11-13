package hu.schonherz.kepzes.java.core.tools;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import hu.schonherz.kepzes.java.core.UserService;
import hu.schonherz.kepzes.java.core.UserServiceImpl;
@EnableWebMvc
@Configuration
@ComponentScan(basePackages={ "hu.schonherz.kepzes.java.core" })
@PropertySource("classpath:spring-jdbc.properties")
public class WebConfig {

	public WebConfig(){
		System.out.println("WebConfig Constructor!");
	}

	@Bean
	public UserService userService() {
		System.out.println("userService activated! :)");
		UserServiceImpl userService = new UserServiceImpl();
		//userService.setUserDao(userDao());
		return  userService;
	}
	
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
}