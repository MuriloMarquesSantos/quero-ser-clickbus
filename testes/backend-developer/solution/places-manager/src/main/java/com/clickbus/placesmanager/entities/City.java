package com.clickbus.placesmanager.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class City {

    @Id
    @GeneratedValue
    private Long id;

    private String cityId;

    @Column(nullable = false, unique = true)
    private String cityName;

    @ManyToOne
    private State state;

    @PrePersist
    private void generateCityId() {
        this.cityId = UUID.randomUUID().toString();
    }
}
