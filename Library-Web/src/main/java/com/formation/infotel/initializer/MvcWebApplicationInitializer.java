package com.formation.infotel.initializer;

import com.formation.infotel.config.SpringConfig;
import com.formation.infotel.config.WebConfig;
import com.formation.infotel.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses(){
        return new Class[] { SpringConfig.class, WebSecurityConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses(){
        return new Class[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings(){
        return new String[] { "/jsp/" };
    }
}
