package com.example.demo.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class SecurityConfig<BCryptPasswordEncoder> implements WebMvcConfigurer {

   @Override
   public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping("/**")
               .allowedOrigins("http://localhost:3000") // Adjust for frontend URL
               .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Include OPTIONS for preflight
               .allowedHeaders("*")
               .allowCredentials(true); // Important for cookies and authentication headers
   }

   @Bean
   public <SecurityFilterChain, HttpSecurity> SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
{
       http
           .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Enable CORS
           .csrf(csrf -> csrf.disable()) // Disable CSRF if not needed
           .authorizeHttpRequests(authz -> authz
               .anyRequest().permitAll() // Permit all requests (adjust as needed)
           );

       return http.build();
   }

   @Bean
   public Authentication authenticationManager(AopAutoConfiguration config) throws Exception {
       return config.getAuthenticationManager();
   }

   @Bean
   public BCryptPasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
}

@Bean
   public CorsConfigurationSource corsConfigurationSource() {
       CorsConfiguration configuration = new CorsConfiguration();
       configuration.setAllowedOrigins(List.of("http://localhost:3000")); // Set frontend URL
       configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
       configuration.setAllowedHeaders(List.of("*"));
       configuration.setAllowCredentials(true);

       UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
       source.registerCorsConfiguration("/**", configuration);
       return source;
   }
}

