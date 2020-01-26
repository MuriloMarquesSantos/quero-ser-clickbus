package com.clickbus.placesmanager.application.requestmodels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class StateRequestModel {

    private String stateName;
}
