package com.clickbus.placesmanager.services.impl.helper;

import com.clickbus.placesmanager.dto.request.StateRequestModel;
import com.clickbus.placesmanager.dto.response.StateResponseModel;
import com.clickbus.placesmanager.entities.State;
import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;

public class StateTestHelper {

    private static final Faker faker = new Faker();

    private StateTestHelper(){}

    public static State createValidStateEntity() {
        return State.builder()
                .stateName(faker.address().state())
                .stateId(faker.idNumber().valid())
                .build();

    }

    public static List<State> createListOfValidStateEntity() {
        return Arrays.asList(
                createValidStateEntity(),
                createValidStateEntity());
    }

    public static StateResponseModel createValidStateResponseModel() {
        return StateResponseModel.builder()
                .stateName(faker.address().state())
                .stateId(faker.idNumber().valid())
                .build();
    }
}
