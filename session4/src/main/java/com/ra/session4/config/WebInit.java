package com.ra.session4.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // các cấu hình gốc k liên quan tới web
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // cấu hình servlet liên quan đến web
        return new Class[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // ánh xạ đường dẫn
        return new String[]{"/"};
    }

    // Cấu hình liên quan đến UTF-8 để xử lý các ký tự

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter("utf-8", true);
        return new Filter[]{filter};
    }
}
