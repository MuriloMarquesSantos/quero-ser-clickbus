package com.clickbus.placesmanager.services;

import com.clickbus.placesmanager.dto.request.StateRequestModel;
import com.clickbus.placesmanager.dto.response.StateResponseModel;

import java.util.List;

public interface StateService {
    StateResponseModel createState(StateRequestModel stateRequestModel);
    List<StateResponseModel> getStates();
}
