package com.Incubation.Configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("transaction-service", r -> r.path("/transaction-service/**")
                        .uri("lb://TRANSACTION-SERVICE"))
//                        .uri("http://localhost:8082"))
                .route("users-service", r -> r.path("/users-service/**")
                        .uri("lb://USERS-SERVICE"))
//                        .uri("http://localhost:8081"))
                .build();
    }

    @Bean
    public CorsWebFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:3000"); // Allow the React frontend
        config.addAllowedHeader("*"); // Allow all headers
        config.addAllowedMethod("*"); // Allow all HTTP methods (GET, POST, etc.)
        config.setAllowCredentials(true); // Allow credentials like cookies or authorization headers
        source.registerCorsConfiguration("/**", config);
        return new CorsWebFilter(source);
    }

//    @Bean
//    public CorsWebFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//
//        // Allow the origin of your frontend
//        config.addAllowedOrigin("http://localhost:3000");
//
//        // Allow specific headers (like Content-Type)
//        config.addAllowedHeader("*");
//
//        // Allow specific methods
//        config.addAllowedMethod("*");
//
//        // Allow credentials (if needed)
//        config.setAllowCredentials(true);
//
//        source.registerCorsConfiguration("/**", config);
//        return new CorsWebFilter(source);
//    }
//
    private UrlBasedCorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.addAllowedOrigin("http://localhost:3000"); // Allow the frontend origin
        config.addAllowedHeader("*"); // Allow all headers
        config.addAllowedMethod("*"); // Allow all methods (GET, POST, etc.)
        config.setAllowCredentials(true); // Allow credentials (like cookies)

        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
