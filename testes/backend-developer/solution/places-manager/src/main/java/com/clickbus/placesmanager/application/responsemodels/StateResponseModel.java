package com.clickbus.placesmanager.application.responsemodels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class StateResponseModel {
    private String stateId;
    private String stateName;
}
