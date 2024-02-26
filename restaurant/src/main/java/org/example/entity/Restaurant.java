package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
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

    private String name;

    private String location;
}
