package com.clickbus.placesmanager.services;

import com.clickbus.placesmanager.application.requestmodels.StateRequestModel;
import com.clickbus.placesmanager.application.responsemodels.StateResponseModel;

import java.util.List;

public interface StateService {
    StateResponseModel createState(StateRequestModel stateRequestModel);
    List<StateResponseModel> getStates();
}
