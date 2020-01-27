package com.clickbus.placesmanager.services.impl;

import com.clickbus.placesmanager.application.requestmodels.StateRequestModel;
import com.clickbus.placesmanager.application.responsemodels.StateResponseModel;
import com.clickbus.placesmanager.entities.State;
import com.clickbus.placesmanager.repository.StateRepository;
import com.clickbus.placesmanager.services.StateService;
import com.clickbus.placesmanager.utils.ModelMapperFactory;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class StateServiceImpl implements StateService {

    private StateRepository stateRepository;

    @Override
    public StateResponseModel createState(StateRequestModel stateRequestModel) {
        ModelMapper modelMapper = ModelMapperFactory.getInstance();
        State createdState = modelMapper.map(stateRequestModel, State.class);
        return modelMapper.map(stateRepository.save(createdState), StateResponseModel.class);
    }

    @Override
    public List<StateResponseModel> getStates() {
        ModelMapper modelMapper = ModelMapperFactory.getInstance();
        List<State> stateList = stateRepository.findAll();

        if (stateList.isEmpty()) {
            //TO-DO enhance exception
            throw new RuntimeException("No states found");
        }

        List<StateResponseModel> returnValues = new ArrayList<>();
        stateList.forEach(state -> {
            returnValues.add(modelMapper.map(state, StateResponseModel.class));
        });

        return returnValues;
    }
}
