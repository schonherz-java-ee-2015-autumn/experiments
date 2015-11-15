package hu.schonherz.kepzes.java.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import hu.schonherz.kepzes.java.core.tools.CoreConfig;
import hu.schonherz.kepzes.java.core.tools.WebConfig;
public class SpringInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	public SpringInitializer() {
		System.out.println("SpringMvcInitializer");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("getRootConfigClasses");
		return new Class[] {CoreConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("getServletConfigClasses");
		return new Class[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/WebApp/" };
	}


}
