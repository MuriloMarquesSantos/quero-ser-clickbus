package com.clickbus.placesmanager.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StateRequestModel {

    @NotNull
    private String stateName;
}
