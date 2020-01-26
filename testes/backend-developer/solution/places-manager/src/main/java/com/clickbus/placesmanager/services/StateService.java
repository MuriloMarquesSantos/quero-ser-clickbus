package com.clickbus.placesmanager.services;

import com.clickbus.placesmanager.application.requestmodels.StateRequestModel;
import com.clickbus.placesmanager.application.responsemodels.StateResponseModel;

public interface StateService {
    public StateResponseModel createState(StateRequestModel stateRequestModel);
}
