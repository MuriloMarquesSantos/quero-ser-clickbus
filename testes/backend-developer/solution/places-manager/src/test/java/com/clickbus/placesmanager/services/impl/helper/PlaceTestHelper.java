package com.clickbus.placesmanager.services.impl.helper;

import com.clickbus.placesmanager.dto.response.PlaceResponseModel;
import com.clickbus.placesmanager.entities.Place;
import com.github.javafaker.Faker;
import com.github.slugify.Slugify;

import java.util.Arrays;
import java.util.List;

import static com.clickbus.placesmanager.services.impl.helper.CityTestHelper.*;

public class PlaceTestHelper {

    private PlaceTestHelper() {}

    private static final Faker faker = new Faker();
    private static final Slugify slugifier = new Slugify();
    private static final String PLACE_NAME = faker.address().streetName();
    private static final String SLUG = slugifier.slugify(PLACE_NAME);

    public static Place createValidPlaceEntity() {
        return Place.builder()
                .placeName(PLACE_NAME)
                .slug(SLUG)
                .city(createValidCityEntity())
                .placeId(faker.idNumber().valid())
                .build();
    }

    public static List<Place> createListOfValidPlaceEntity() {
        return Arrays.asList(
                createValidPlaceEntity(),
                createValidPlaceEntity());
    }

    public static PlaceResponseModel createValidPlaceResponseModel() {
        return PlaceResponseModel.builder()
                .city(createValidCityResponseModel())
                .placeId(faker.idNumber().valid())
                .placeName(PLACE_NAME)
                .slug(SLUG)
                .build();
    }

    public static List<PlaceResponseModel> createListOfPlaceResponseModel() {
        return Arrays.asList(
                createValidPlaceResponseModel(),
                createValidPlaceResponseModel()
        );
    }
}
