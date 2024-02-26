package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${aui.gateway.host}") String host
    ) {
        return builder
                .routes()
                .route("restaurants", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/restaurants/{uuid}",
                                "/api/restaurants"
                        )
                        .uri("lb://restaurant")
                )
                .route("pizzas", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/pizzas",
                                "/api/pizzas/**",
                                "/api/restaurants/{uuid}/pizzas",
                                "/api/restaurants/{uuid}/pizzas/**"
                        )
                        .uri("lb://pizza")
                )
                .build();
    }

}
