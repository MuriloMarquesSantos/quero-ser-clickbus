package com.clickbus.placesmanager.services.impl.helper;

import com.clickbus.placesmanager.dto.request.CityRequestModel;
import com.clickbus.placesmanager.dto.response.CityResponseModel;
import com.clickbus.placesmanager.entities.City;
import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;

import static com.clickbus.placesmanager.services.impl.helper.StateTestHelper.createValidStateEntity;
import static com.clickbus.placesmanager.services.impl.helper.StateTestHelper.createValidStateResponseModel;

public class CityTestHelper {

    private static final Faker faker = new Faker();

    private CityTestHelper(){}

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

    public static CityResponseModel createValidCityResponseModel() {
        return CityResponseModel.builder()
                .cityName(faker.address().cityName())
                .cityId(faker.idNumber().valid())
                .state(createValidStateResponseModel())
                .build();
    }

    public static List<CityResponseModel> createListOfValidCityResponseModel() {
        return Arrays.asList(
                createValidCityResponseModel(),
                createValidCityResponseModel()
        );
    }

    public static CityRequestModel createValidCityRequestModel() {
        return CityRequestModel.builder()
                .cityName(faker.address().cityName())
                .stateId(faker.idNumber().valid())
                .build();
    }

    public static CityRequestModel createInvalidCityRequestModel() {
        return CityRequestModel.builder()
                .cityName(faker.address().cityName())
                .build();
    }
 }
