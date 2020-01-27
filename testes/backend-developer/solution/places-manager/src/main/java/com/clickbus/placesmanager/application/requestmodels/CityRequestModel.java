package com.clickbus.placesmanager.application.requestmodels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CityRequestModel {

    private String cityName;
    private String stateId;
}
