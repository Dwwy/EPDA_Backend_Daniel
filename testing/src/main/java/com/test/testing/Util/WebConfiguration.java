package com.test.testing.Util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


@Configuration

public class WebConfiguration extends WebMvcConfigurationSupport {

    @Override
    protected void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setPathMatcher(new AntPathMatcher(){{
                                      setCaseSensitive(false);
                                  }}
        );
    }
}