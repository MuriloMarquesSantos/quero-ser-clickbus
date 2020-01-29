package com.clickbus.placesmanager.services.impl.helper;

import com.clickbus.placesmanager.application.request.CityRequestModel;
import com.clickbus.placesmanager.entities.City;

import static com.clickbus.placesmanager.services.impl.helper.StateServiceImplTestHelper.createValidStateEntity;

public class CityServiceImplTestHelper {

    private CityServiceImplTestHelper(){}

    public static City createValidCityEntity() {
        return City.builder()
                .cityName("Rio de Janeiro")
                .state(createValidStateEntity())
                .build();
    }

    public static CityRequestModel createValidCityRequestModel() {
        return CityRequestModel.builder()
                .cityName("Rio de Janeiro")
                .stateId(createValidStateEntity().getStateId())
                .build();
    }
 }
