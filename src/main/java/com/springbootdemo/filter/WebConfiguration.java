package com.springbootdemo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

    @Bean
    public FilterRegistrationBean testFilterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        //设置过滤器
        filterRegistrationBean.setFilter(new MyFilter());
        //设置过滤URL
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setName("MyFilter");
        //设置优先级,值越低，优先级越高
        filterRegistrationBean.setOrder(6);
        return  filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean test2FilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter2());
        registration.addUrlPatterns("/*");
        registration.setName("MyFilter2");
        registration.setOrder(1);
        return registration;
    }
}
