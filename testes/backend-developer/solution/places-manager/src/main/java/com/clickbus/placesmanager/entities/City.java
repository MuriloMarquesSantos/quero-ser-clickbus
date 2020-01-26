package com.clickbus.placesmanager.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class City {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String cityName;

    @ManyToOne
    private State state;
}
