package com.test.config;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;
import lombok.extern.slf4j.Slf4j;


/**
 * @author Jean-Francois Larouche jealar2 on 2018-08-21
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
@Profile("unsecure")
public class NoSecurityConfig extends WebSecurityConfigurerAdapter {

    public NoSecurityConfig() {}

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
        http.headers().frameOptions().sameOrigin();
        http
                .csrf().disable()
                .authorizeRequests().anyRequest().permitAll()
                .and()
                .addFilterBefore(new HardcodedAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication();
    }

    static class HardcodedAuthenticationFilter extends OncePerRequestFilter {

        public HardcodedAuthenticationFilter() {}

        @Override
        protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain filterChain)
                throws ServletException,
                IOException {

            String roles = request.getHeader("X-Test-Roles");
            List<UserAuthority> authorities;
            if (StringUtils.isNotBlank(roles)) {
                authorities = Arrays.stream(roles.split(",")).map(role -> new UserAuthority(role)).collect(Collectors.toList());
            } else {
                authorities = Arrays.asList(new UserAuthority("ROLE_TEST_ADMIN"), new UserAuthority("ROLE_TEST_USERS"));
            }

            UserContext userContext = new UserContext("test",
                    "test",
                    "test@localhost.com",
                    "test",
                    "test",
                    "",
                    authorities);

            Authentication authentication = new UsernamePasswordAuthenticationToken(userContext, "", userContext.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);
        }
    }
}

