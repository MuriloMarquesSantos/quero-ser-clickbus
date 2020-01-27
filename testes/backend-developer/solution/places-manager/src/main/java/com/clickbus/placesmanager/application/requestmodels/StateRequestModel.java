package com.clickbus.placesmanager.application.requestmodels;

import lombok.*;

import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StateRequestModel {

    @NotNull
    private String stateName;
}
