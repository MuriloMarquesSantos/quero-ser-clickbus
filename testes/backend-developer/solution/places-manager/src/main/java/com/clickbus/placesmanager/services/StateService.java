package com.clickbus.placesmanager.services;

import com.clickbus.placesmanager.application.requestmodels.StateRequestModel;
import com.clickbus.placesmanager.application.responsemodels.StateResponseModel;

public interface StateService {
    StateResponseModel createState(StateRequestModel stateRequestModel);
}
