package com.harmathuwebLogin;


import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Component
public class RestWebAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
	    return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
	    return new Class<?>[] { RepositoryRestMvcConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
	    return new String[] { "/myapp/*" };
	}

	@Override
	protected javax.servlet.Filter[] getServletFilters() {
	    return null;
	}

	@Override
	protected String getServletName() {
	    return "rest-exporter";
	}

}
