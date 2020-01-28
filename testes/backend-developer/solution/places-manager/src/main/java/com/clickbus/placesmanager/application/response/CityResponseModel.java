package com.clickbus.placesmanager.application.response;

import com.clickbus.placesmanager.entities.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CityResponseModel {

    private String cityId;
    private String cityName;
    private State state;
}
