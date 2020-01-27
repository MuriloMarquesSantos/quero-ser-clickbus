package com.clickbus.placesmanager.application.responsemodels;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StateResponseModel {
    private String stateId;
    private String stateName;
}
