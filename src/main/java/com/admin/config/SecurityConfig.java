package com.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((req) ->
            req.requestMatchers("/assets/**").permitAll()
                .requestMatchers("/**").hasRole("ADMIN")
            )
        //.formLogin(withDefaults());
        .formLogin(form -> form.defaultSuccessUrl("/"));

        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//            .username("user")
//            .password("1234")
//            .roles("USER")
//            .build();
//        UserDetails admin = User.withDefaultPasswordEncoder()
//            .username("admin")
//            .password("1234")
//            .roles("ADMIN", "USER")
//            .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }

    @Bean
    public PasswordEncoder encrypt(){

        return new BCryptPasswordEncoder();
    }
}
