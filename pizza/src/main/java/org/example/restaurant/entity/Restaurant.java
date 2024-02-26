package org.example.restaurant.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.pizza.entity.Pizza;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@ToString
@Table(name = "restaurants")
public class Restaurant implements Serializable {
    @Id
    private UUID id;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Pizza> pizzaList;
}
