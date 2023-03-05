package com.flickspot.demo.config;

import com.flickspot.demo.model.User;
import com.flickspot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login/**", "/oauth2/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .loginPage("/login")
                .userInfoEndpoint()
                .userService(oAuth2UserService)
                .and()
                .defaultSuccessURL("/home")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(userService.passwordEncoder());
    }

    @Bean
    public OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService() {
        DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
        return request -> {
            OAuth2User user = delegate.loadUser(request);
            String email = user.getAttribute("email");
            User user = new User();
            user.setEmail(email);
            userService.saveUser(user);
            return user;
        };
    }
}