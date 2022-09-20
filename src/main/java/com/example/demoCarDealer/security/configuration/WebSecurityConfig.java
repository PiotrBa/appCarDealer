package com.example.demoCarDealer.security.configuration;


import com.example.demoCarDealer.appUser.AppUserservice;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {


    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AppUserservice appUserservice;



    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/used/v*/**")
                .permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin();
        return http.build();
    }


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(appUserservice);
        return provider;
    }
}
