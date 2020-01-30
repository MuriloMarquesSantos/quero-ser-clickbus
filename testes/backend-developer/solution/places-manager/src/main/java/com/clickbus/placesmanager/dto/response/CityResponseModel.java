package com.clickbus.placesmanager.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CityResponseModel {

    private String cityId;
    private String cityName;
    private StateResponseModel state;
}
