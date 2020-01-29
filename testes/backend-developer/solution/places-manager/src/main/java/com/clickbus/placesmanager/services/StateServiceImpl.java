package com.clickbus.placesmanager.services;

import com.clickbus.placesmanager.application.request.StateRequestModel;
import com.clickbus.placesmanager.application.response.StateResponseModel;
import com.clickbus.placesmanager.entities.State;
import com.clickbus.placesmanager.repository.StateRepository;
import com.clickbus.placesmanager.utils.ModelMapperFactory;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        return Optional.ofNullable(stateList)
                .filter(list -> !list.isEmpty())
                .orElseThrow(RuntimeException::new)
                .stream()
                .map(state -> modelMapper.map(state, StateResponseModel.class))
                .collect(Collectors.toList());
    }
}
