package com.kami.mall.config;

import com.kami.mall.filter.FilterDemo;
import com.kami.mall.interceptor.InterceptorDemo;
import com.kami.mall.interceptor.UserLoginInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

/**
 * @author yangzi
 * @date 2021-06-22 1:53 PM
 */
@Configuration
@EnableTransactionManagement
public class config implements WebMvcConfigurer {

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dynamicDatasource) {
        return new DataSourceTransactionManager(dynamicDatasource);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptorDemo()).addPathPatterns("/brand/add");

        registry.addInterceptor(new UserLoginInterceptor()).addPathPatterns("/**");
    }

    @Bean
    @Order(2)
    public FilterRegistrationBean configFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new FilterDemo());
        filterRegistrationBean.addUrlPatterns("/brand/add");
        filterRegistrationBean.setName("sessionFilter");
        return filterRegistrationBean;
    }


}
