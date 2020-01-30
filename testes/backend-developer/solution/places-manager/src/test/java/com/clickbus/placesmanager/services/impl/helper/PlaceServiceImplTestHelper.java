package com.clickbus.placesmanager.services.impl.helper;

import com.clickbus.placesmanager.dto.request.PlaceRequestModel;
import com.clickbus.placesmanager.entities.City;
import com.clickbus.placesmanager.entities.Place;
import com.github.javafaker.Faker;
import com.github.slugify.Slugify;

import java.util.Arrays;
import java.util.List;

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

    public static List<Place> createListOfValidPlaceEntity() {
        return Arrays.asList(
                createValidPlaceEntity(),
                createValidPlaceEntity());
    }
}
