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
public class PutPizzaRequest {
    private String name;
    private Integer diameter;
    private Double cost;
    private UUID restaurant;
}
