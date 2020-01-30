package com.clickbus.placesmanager.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StateResponseModel {
    private String stateId;
    private String stateName;
}
