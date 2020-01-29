package com.clickbus.placesmanager.services.impl.helper;

import com.clickbus.placesmanager.application.request.PlaceRequestModel;
import com.clickbus.placesmanager.entities.Place;

import static com.clickbus.placesmanager.services.impl.helper.CityServiceImplTestHelper.*;

public class PlaceServiceImplTestHelper {

    private PlaceServiceImplTestHelper() {}

    public static Place createValidPlaceEntity() {
        return Place.builder()
                .placeName("Av francisco morato")
                .slug("av-francisco-morato")
                .city(createValidCityEntity())
                .placeId("123123-C1312312-C")
                .build();
    }

    public static PlaceRequestModel createValidPlaceRequestModel() {
        return PlaceRequestModel.builder()
                .placeName("Av francisco morato")
                .cityId(createValidCityEntity().getCityId())
                .build();
    }
}
