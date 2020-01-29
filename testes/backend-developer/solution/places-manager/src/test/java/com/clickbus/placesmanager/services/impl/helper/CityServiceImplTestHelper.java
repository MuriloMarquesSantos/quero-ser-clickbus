package com.clickbus.placesmanager.services.impl.helper;

import com.clickbus.placesmanager.application.request.CityRequestModel;
import com.clickbus.placesmanager.entities.City;
import com.github.javafaker.Faker;

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

    public static CityRequestModel createValidCityRequestModel() {
        return CityRequestModel.builder()
                .cityName(faker.address().cityName())
                .stateId(createValidStateEntity().getStateId())
                .build();
    }
 }
