package com.odw.crud.repo.demo.security;

import com.odw.crud.repo.demo.security.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Configuration
    @Order(0)
    public static class RestSecurityConfig extends WebSecurityConfigurerAdapter {

        @Value("${spring.security.username}")
        String username;

        @Value("${spring.security.password}")
        String password;

        @Autowired
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .inMemoryAuthentication()
                    .withUser(username).password(password).roles(Role.REST_USER.name());
        }

        @SuppressWarnings("deprecation")
        @Bean
        public static NoOpPasswordEncoder passwordEncoder() {
            return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
        }


        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http
                    .httpBasic().and()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/**").hasRole(Role.REST_USER.name())
                    .antMatchers(HttpMethod.GET, "/**").hasRole(Role.REST_USER.name())
                    .antMatchers(HttpMethod.PUT, "/**").hasRole(Role.REST_USER.name())
                    .antMatchers(HttpMethod.PATCH, "/**").hasRole(Role.REST_USER.name())
                    .antMatchers(HttpMethod.DELETE, "/**").hasRole(Role.REST_USER.name())
                    .and()
                    .csrf().disable();
        }
    }
}
