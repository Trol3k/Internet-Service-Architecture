package org.example.pizza.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.restaurant.entity.Restaurant;

import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "pizzas")
public class Pizza implements Serializable {
    @Id
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "diameter")
    private Integer diameter;

    @Column(name = "cost")
    private Double cost;

    @ManyToOne
    @JoinColumn(name = "restaurant")
    private Restaurant restaurant;
}
