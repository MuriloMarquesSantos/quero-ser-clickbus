package com.clickbus.placesmanager.services.impl.helper;

import com.clickbus.placesmanager.dto.request.CityRequestModel;
import com.clickbus.placesmanager.entities.City;
import com.clickbus.placesmanager.entities.State;
import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;

import static com.clickbus.placesmanager.services.impl.helper.StateServiceImplTestHelper.createValidStateEntity;

public class CityServiceImplTestHelper {

    private static final Faker faker = new Faker();

    private CityServiceImplTestHelper(){}

    public static City createValidCityEntity() {
        return City.builder()
                .cityName(faker.address().cityName())
                .cityId(faker.idNumber().valid())
                .state(createValidStateEntity())
                .build();
    }

    public static List<City> createListOfValidCityEntity() {
        return Arrays.asList(
                createValidCityEntity(),
                createValidCityEntity());
    }
 }
