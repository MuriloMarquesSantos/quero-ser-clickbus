package com.clickbus.placesmanager.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class State {

    @Id
    @GeneratedValue
    private Long id;

    private String stateId;

    @NotNull
    private String stateName;

    @PrePersist
    private void generateStateId() {
        this.stateId = UUID.randomUUID().toString();
    }
}
