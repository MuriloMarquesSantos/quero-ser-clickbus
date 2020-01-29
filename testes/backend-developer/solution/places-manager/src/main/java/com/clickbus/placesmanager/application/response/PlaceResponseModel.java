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

    private String placeId;
    private String placeName;
    private String slug;
    private CityResponseModel city;
}
