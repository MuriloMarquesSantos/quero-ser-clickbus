package com.clickbus.placesmanager.services;

import com.clickbus.placesmanager.application.request.StateRequestModel;
import com.clickbus.placesmanager.application.response.StateResponseModel;

import java.util.List;

public interface StateService {
    StateResponseModel createState(StateRequestModel stateRequestModel);
    List<StateResponseModel> getStates();
}
