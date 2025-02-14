package com.example.EasyLearn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;


@Configuration
@EnableMethodSecurity  // Enables @PreAuthorize
public class SecurityConfig {

    //using DB for auth and author for default tables and column name
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
    //using DB for auth and author for custom tables and column name
//    @Bean
//    public UserDetailsManager userDetailsManager1(DataSource dataSource){
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//        jdbcUserDetailsManager.setUsersByUsernameQuery("select username, pass,active from members where username=?");
//        jdbcUserDetailsManager.setGroupAuthoritiesByUsernameQuery("select username, role from roles where username=?");
//        return  jdbcUserDetailsManager;
//    }

    // specify authorization roles
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer -> {
                    configurer
                            .requestMatchers(HttpMethod.GET, "api/tasks").hasAnyRole("EMP", "MANAGER", "ADMIN")
                            .requestMatchers(HttpMethod.POST, "api/tasks").hasAnyRole("MANAGER", "ADMIN")
                            .requestMatchers(HttpMethod.PUT, "api/tasks/**").hasAnyRole("MANAGER", "ADMIN")
                            .requestMatchers(HttpMethod.DELETE, "api/tasks/**").hasRole("ADMIN")

                            .anyRequest().authenticated();

                }
        )
                .formLogin(formlogin -> formlogin.loginPage("/showloginpage").loginProcessingUrl("/proccesslogin").permitAll())
                .logout(LogoutConfigurer::permitAll)
                .exceptionHandling(config->config.accessDeniedPage("/accessdenied"))
                ;
        // secure anyRequest
//        httpSecurity.authorizeHttpRequests(configurer ->configurer.anyRequest().authenticated())
//                        .formLogin(f -> f.loginPage("/showloginpage")
//                                .loginProcessingUrl("/proccesslogin")
//                                        .permitAll())
//                .logout(LogoutConfigurer::permitAll
//                );

        httpSecurity.httpBasic(Customizer.withDefaults());
        // httpSecurity.csrf(csrf -> csrf.disable());
        //httpSecurity.csrf(AbstractHttpConfigurer::disable);
        return httpSecurity.build();
    }
}
//
//   using memory for auth and author
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails user = User.builder()
//                .username("ahmed")
//                .password("{noop}test123")
//                .roles("EMP")
//                .build();
//        UserDetails manager = User.builder()
//                .username("ali")
//                .password("{noop}test123")
//                .roles("EMP", "MANAGER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("mahmoud")
//                .password("{noop}test123")
//                .roles("EMP", "MANAGER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, manager, admin);
//    }
//
//}



// disable authentication
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
//                        .anyRequest().permitAll()  // Permits all requests without authentication
//                )
//                .httpBasic(Customizer.withDefaults())
//                .csrf(AbstractHttpConfigurer::disable);  // Disables CSRF protection
//
//        return httpSecurity.build();
//    }
//}
