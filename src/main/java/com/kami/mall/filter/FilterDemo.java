package com.kami.mall.filter;

import com.sun.xml.bind.util.Which;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author yangzi
 * @date 2021-06-25 10:29 AM
 */
public class FilterDemo implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化...");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        System.out.println("过滤器开始工作..." + httpServletRequest.getRequestURL());
        Enumeration<String> parameterNames = httpServletRequest.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();
            System.out.println(s);
        }
        chain.doFilter(request, response);
    }
}
