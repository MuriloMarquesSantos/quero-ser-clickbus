package com.clickbus.placesmanager.application.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StateResponseModel {
    private String stateId;
    private String stateName;
}
