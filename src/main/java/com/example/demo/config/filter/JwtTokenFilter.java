package com.example.demo.config.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.example.demo.config.security.JwtTokenProvider;

import org.springframework.web.filter.GenericFilterBean;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class JwtTokenFilter extends GenericFilterBean {
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public void doFilter(ServletRequest req, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        String token = jwtTokenProvider.resolveToken(request);
    }

    
}