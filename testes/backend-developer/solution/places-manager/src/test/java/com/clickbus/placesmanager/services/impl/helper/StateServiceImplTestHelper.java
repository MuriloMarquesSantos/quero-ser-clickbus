package com.clickbus.placesmanager.services.impl.helper;

import com.clickbus.placesmanager.dto.request.StateRequestModel;
import com.clickbus.placesmanager.entities.State;
import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;

public class StateServiceImplTestHelper {

    private static final Faker faker = new Faker();

    private StateServiceImplTestHelper(){}

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
}
