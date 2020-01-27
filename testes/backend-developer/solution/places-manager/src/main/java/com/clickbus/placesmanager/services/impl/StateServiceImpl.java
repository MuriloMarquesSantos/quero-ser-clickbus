package com.clickbus.placesmanager.services.impl;

import com.clickbus.placesmanager.application.requestmodels.StateRequestModel;
import com.clickbus.placesmanager.application.responsemodels.StateResponseModel;
import com.clickbus.placesmanager.entities.State;
import com.clickbus.placesmanager.repository.StateRepository;
import com.clickbus.placesmanager.services.StateService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StateServiceImpl implements StateService {

    private StateRepository stateRepository;

    @Override
    public StateResponseModel createState(StateRequestModel stateRequestModel) {
        ModelMapper modelMapper = new ModelMapper();
        State createdState = modelMapper.map(stateRequestModel, State.class);
        return modelMapper.map(stateRepository.save(createdState), StateResponseModel.class);
    }
}
