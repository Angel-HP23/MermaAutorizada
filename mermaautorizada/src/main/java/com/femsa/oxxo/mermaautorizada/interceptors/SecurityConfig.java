package com.femsa.oxxo.mermaautorizada.interceptors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Value("${service.security.secure-key-username-administrador}")
    private String SECURE_KEY_USERNAME_ADMINISTRADOR;

    @Value("${service.security.secure-key-password-administrador}")
    private String SECURE_KEY_PASSWORD_ADMINISTRADOR;

    @Value("${service.security.secure-key-username-consultor}")
    private String SECURE_KEY_USERNAME_CONSULTOR;

    @Value("${service.security.secure-key-password-consultor}")
    private String SECURE_KEY_PASSWORD_CONSULTOR;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http ) throws Exception {

        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser(SECURE_KEY_USERNAME_ADMINISTRADOR)
                .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASSWORD_ADMINISTRADOR))
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ADMINISTRADOR"))
                .and()
                .withUser(SECURE_KEY_USERNAME_CONSULTOR)
                .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASSWORD_CONSULTOR))
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("CONSULTOR"))
                .and()
                .passwordEncoder(new BCryptPasswordEncoder());

        return http.antMatcher("/**")
                .authorizeHttpRequests()
                .anyRequest()
                //.hasRole
                .permitAll()
                .and()
                .csrf()
                .disable()
                .httpBasic()
                .and()
                .exceptionHandling()
              // .accessDeniedHandler(((request, response, exception) -> { response.sendRedirect("https://okdiario.com/img/2018/03/13/como-calcular-porcentaje-de-error-655x368.jpg");} ))
                .and()
                .build();

    }

}
