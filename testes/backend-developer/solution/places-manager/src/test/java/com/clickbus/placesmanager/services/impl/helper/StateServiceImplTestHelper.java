package com.clickbus.placesmanager.services.impl.helper;

import com.clickbus.placesmanager.application.request.StateRequestModel;
import com.clickbus.placesmanager.application.response.StateResponseModel;
import com.clickbus.placesmanager.entities.State;
import com.github.javafaker.Faker;

public class StateServiceImplTestHelper {

    private static final Faker faker = new Faker();

    private StateServiceImplTestHelper(){}

    public static State createValidStateEntity() {
        return State.builder()
                .stateName(faker.address().state())
                .stateId(faker.idNumber().valid())
                .build();

    }

    public static StateRequestModel createValidStateRequestModel() {
        return StateRequestModel.
                builder().
                stateName(faker.address().state()).build();
    }
}
