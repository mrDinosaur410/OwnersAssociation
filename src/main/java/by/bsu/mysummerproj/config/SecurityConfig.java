package by.bsu.mysummerproj.config;

import by.bsu.mysummerproj.entity.Role;
import by.bsu.mysummerproj.service.impl.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomUserDetailsService userDetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) ->
                        authorize
//                                .requestMatchers(HttpMethod.GET, "/login").permitAll()
//                                .requestMatchers(HttpMethod.GET, "/logout").permitAll()
//                                .requestMatchers(HttpMethod.GET, "/admin/**").hasRole("ADMIN")
//                                .requestMatchers(HttpMethod.POST, "/admin/**").hasRole("ADMIN")
                                .anyRequest().permitAll()
                )
                .formLogin(config -> config.defaultSuccessUrl("/home"))
                .logout(config -> config.logoutSuccessUrl("/login"))
                .build();
    }
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
