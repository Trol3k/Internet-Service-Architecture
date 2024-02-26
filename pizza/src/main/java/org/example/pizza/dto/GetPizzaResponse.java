package org.example.pizza.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode

public class GetPizzaResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Restaurant {
        private UUID id;
    }

    private UUID id;
    private String name;
    private Integer diameter;
    private Double cost;
    private Restaurant restaurant;

}
