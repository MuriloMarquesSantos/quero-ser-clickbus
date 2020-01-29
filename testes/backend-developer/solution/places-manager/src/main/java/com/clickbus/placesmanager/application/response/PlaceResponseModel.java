package com.clickbus.placesmanager.application.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlaceResponseModel {

    private String cityId;
    private String cityName;
    private String slug;
    private CityResponseModel cityResponseModel;
}
