package com.clickbus.placesmanager.services.impl.helper;

import com.clickbus.placesmanager.dto.request.PlaceRequestModel;
import com.clickbus.placesmanager.entities.Place;
import com.github.javafaker.Faker;
import com.github.slugify.Slugify;

import static com.clickbus.placesmanager.services.impl.helper.CityServiceImplTestHelper.*;

public class PlaceServiceImplTestHelper {

    private PlaceServiceImplTestHelper() {}

    private static final Faker faker = new Faker();
    private static final Slugify slugifier = new Slugify();

    public static Place createValidPlaceEntity() {
        String placeName = faker.address().streetName();
        return Place.builder()
                .placeName(placeName)
                .slug(slugifier.slugify(placeName))
                .city(createValidCityEntity())
                .placeId(faker.idNumber().valid())
                .build();
    }

    public static PlaceRequestModel createValidPlaceRequestModel() {
        return PlaceRequestModel.builder()
                .placeName(faker.address().streetName())
                .cityId(createValidCityEntity().getCityId())
                .build();
    }
}
