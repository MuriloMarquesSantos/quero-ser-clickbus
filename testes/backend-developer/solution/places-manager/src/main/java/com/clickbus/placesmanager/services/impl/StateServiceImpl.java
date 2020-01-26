package com.clickbus.placesmanager.services.impl;

import com.clickbus.placesmanager.application.requestmodels.StateRequestModel;
import com.clickbus.placesmanager.application.responsemodels.StateResponseModel;
import com.clickbus.placesmanager.services.StateService;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl implements StateService {

    @Override
    public StateResponseModel createState(StateRequestModel stateRequestModel) {
        return StateResponseModel.builder().build();
    }
}
