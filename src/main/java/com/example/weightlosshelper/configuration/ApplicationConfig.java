package com.example.weightlosshelper.configuration;

import com.example.weightlosshelper.dao.UserInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final UserInformationRepository userInformationRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userInformationRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
     @Bean
     public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
     }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Allow specific origins
        configuration.addAllowedOrigin("http://localhost:3000");
        configuration.addAllowedOrigin("http://192.168.0.214:3000");

        // Allow all HTTP methods
        configuration.addAllowedMethod("*");

        // Allow all headers
        configuration.addAllowedHeader("*");

        // Allow credentials (e.g., cookies)
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
    @Bean
    public FilterRegistrationBean<Corsfilter> corsFilterRegistration() {
        FilterRegistrationBean<Corsfilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new Corsfilter());
        registrationBean.addUrlPatterns("/*"); // Apply the filter to all URLs
        return registrationBean;
    }


}
