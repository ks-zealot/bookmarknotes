package org.bookmarknotes.security;

import org.bookmarknotes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.Filter;

/**
 * Created by zealot on 08.08.18.
 */
@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private   PasswordEncoder passwordEncoder;
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/",  "/register").permitAll()
                .anyRequest().fullyAuthenticated().and()
                .addFilterBefore(
                        authenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class)
                .logout()
                .logoutUrl("/logout")
                .and().
                httpBasic().and().
                csrf().disable();
    }


    private Filter authenticationFilter() throws Exception {
        UsernamePasswordAuthenticationFilter f = new UsernamePasswordAuthenticationFilter();
                f.setAuthenticationManager(authenticationManagerBean());
        f.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));
        return f;
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Autowired
    public WebSecurity setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        return this;
    }

    @Autowired
    public WebSecurity setUserService(UserService userService) {
        this.userService = userService;
        return this;
    }
}
