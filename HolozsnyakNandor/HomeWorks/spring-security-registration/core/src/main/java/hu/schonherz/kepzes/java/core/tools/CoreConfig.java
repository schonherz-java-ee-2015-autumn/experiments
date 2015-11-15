package hu.schonherz.kepzes.java.core.tools;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import hu.schonherz.kepzes.java.common.CheckerDAO;
import hu.schonherz.kepzes.java.common.UserDAO;
import hu.schonherz.kepzes.java.core.UserService;
import hu.schonherz.kepzes.java.core.UserServiceImpl;
import hu.schonherz.kepzes.java.core.dao.CheckerDAOImpl;
import hu.schonherz.kepzes.java.core.dao.UserDAOImpl;
@EnableWebMvc
@Configuration
@ComponentScan(basePackages={ "hu.schonherz.kepzes.java.core" })
@PropertySource("classpath:spring-jdbc.properties")
public class CoreConfig {

	public CoreConfig(){
		System.out.println("appconfig construtcotr!");
	}
	
	@Bean
	public DriverManagerDataSource dataSource() {
		System.out.println("dataSource activated! :)");
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		
	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/java?useEncoding=true&characterEncoding=UTF-8");
	    driverManagerDataSource.setUsername("root");
	    driverManagerDataSource.setPassword("mysql");
	    return driverManagerDataSource;
	}
	
	@Bean
    public JdbcTemplate jdbcTemplate() {    
        final JdbcTemplate jdbcTemplate = new JdbcTemplate();

        jdbcTemplate.setDataSource(dataSource()); // notice this is calling the other Bean method
        jdbcTemplate.afterPropertiesSet();

        return jdbcTemplate;
    }
	
	@Bean(name="txManager")
	public org.springframework.jdbc.datasource.DataSourceTransactionManager txManager() {
		System.out.println("txManager activated! :)");
		org.springframework.jdbc.datasource.DataSourceTransactionManager txManager = new org.springframework.jdbc.datasource.DataSourceTransactionManager();
		txManager.setDataSource(dataSource());
		return txManager;
	}
	
	@Bean
	public UserDAO userDao() {
		System.out.println("UserDAO activated! :)");
		UserDAOImpl impl = new UserDAOImpl();
		impl.setDataSource(dataSource());
		impl.setJdbcTemplate(jdbcTemplate());
		return impl;
	}
	
	
	@Bean
	public CheckerDAO checkerDao() {
		System.out.println("checkerDao activated! :)");
		CheckerDAOImpl checker = new CheckerDAOImpl();
		checker.setDataSource(dataSource());
		checker.setJdbcTemplate(jdbcTemplate());
		return  checker;
	}
	
	
	
}