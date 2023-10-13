package com.example.weightlosshelper.configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class Corsfilter  extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // Access-Control-Allow-Origin
        String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Vary", "Origin");
     System.out.println(origin);
        // Access-Control-Max-Age
        response.setHeader("Access-Control-Max-Age", "3600");

        // Access-Control-Allow-Credentials
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // Access-Control-Allow-Methods
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");

        // Access-Control-Allow-Headers
        response.setHeader("Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Content-Type, Accept, " + "X-CSRF-TOKEN");


        filterChain.doFilter(request, response);

    }
}
