package org.example.pizza.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchPizzaRequest {
    private String name;
    private Integer diameter;
    private Double cost;
}
