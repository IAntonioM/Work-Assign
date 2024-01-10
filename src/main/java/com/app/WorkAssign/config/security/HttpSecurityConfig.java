package com.app.WorkAssign.config.security;

import com.app.WorkAssign.config.security.filter.JwtAuthenticationFilter;
import com.app.WorkAssign.persistence.util.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JwtAuthenticationFilter authenticationFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrfConfig->csrfConfig.disable())
                .sessionManagement(sessionMangConfig->sessionMangConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(builderRequestMatchers());
        return http.build();
    }

    private static Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> builderRequestMatchers() {
        return authConfig -> {
            authConfig.requestMatchers(HttpMethod.POST, "/auth/authenticate").permitAll();
            authConfig.requestMatchers(HttpMethod.POST, "/auth/register").hasAuthority(Permission.CREATE_CUSTOMER_USER.name());
            authConfig.requestMatchers(HttpMethod.GET, "/auth/public-access").permitAll();
            authConfig.requestMatchers("/error").permitAll();


            authConfig.requestMatchers(HttpMethod.GET, "/api/categories-task").hasAuthority(Permission.READ_ALL_CATEGORIES_TASK.name());
            authConfig.requestMatchers(HttpMethod.POST, "/api/categories-task").hasAuthority(Permission.CREATE_CATEGORIES_TASK.name());

            authConfig.requestMatchers(HttpMethod.GET, "/api/task").hasAuthority(Permission.READ_USER_TASKS.name());
            authConfig.requestMatchers(HttpMethod.POST, "/api/task").hasAuthority(Permission.CREATE_USER_TASK.name());

            //authConfig.requestMatchers(HttpMethod.GET, "/courses").hasAuthority(Permission.READ_ALL_Course.name());
            //authConfig.requestMatchers(HttpMethod.POST, "/courses").hasAuthority(Permission.SAVE_ONE_Course.name());

            authConfig.anyRequest().denyAll();
        };
    }
}

