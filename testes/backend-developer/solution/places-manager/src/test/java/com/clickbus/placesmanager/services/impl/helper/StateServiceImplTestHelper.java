package com.clickbus.placesmanager.services.impl.helper;

import com.clickbus.placesmanager.application.request.StateRequestModel;
import com.clickbus.placesmanager.application.response.StateResponseModel;
import com.clickbus.placesmanager.entities.State;

public class StateServiceImplTestHelper {

    private StateServiceImplTestHelper(){}

    public static State createValidStateEntity() {
        return State.builder()
                .stateName("RJ")
                .stateId("C234234-12312312-1231231")
                .build();

    }

    public static StateRequestModel createValidStateRequestModel() {
        return StateRequestModel.
                builder().
                stateName("RJ").build();
    }
}
