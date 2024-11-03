package javatest.com.example.JavaTest.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestResponseLoggingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        logger.info("Filter is invoked");
        logger.info("Incoming Request: {} {}?{}", httpRequest.getMethod(), httpRequest.getRequestURI(),
                httpRequest.getQueryString() != null ? httpRequest.getQueryString() : "");
        chain.doFilter(request, response);

        logger.info("Outgoing Response: Status={}", httpResponse.getStatus());
    }

//    @Override
//    public void destroy() {
//    }
}
