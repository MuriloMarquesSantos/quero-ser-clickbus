package com.clickbus.placesmanager.services.impl.services;

import com.clickbus.placesmanager.dto.request.StateRequestModel;
import com.clickbus.placesmanager.dto.response.StateResponseModel;
import com.clickbus.placesmanager.entities.State;
import com.clickbus.placesmanager.exception.ResourceNotFoundException;
import com.clickbus.placesmanager.repository.StateRepository;
import com.clickbus.placesmanager.services.StateServiceImpl;
import com.clickbus.placesmanager.utils.ModelMapperFactory;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.clickbus.placesmanager.services.impl.helper.StateServiceImplTestHelper.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StateServiceImplTest {

    @InjectMocks
    private StateServiceImpl stateService;

    @Mock
    private StateRepository stateRepository;

    private static final Faker faker = new Faker();

    private List<State> stateList;
    private List<StateRequestModel> stateRequestModel;

    @Before
    public void setUp() {
        ModelMapper modelMapper = ModelMapperFactory.getInstance();
        stateList = createListOfValidStateEntity();

        stateRequestModel = stateList
                .stream()
                .map(state -> modelMapper.map(state, StateRequestModel.class))
                .collect(Collectors.toList());
    }


    @Test
    public void createStateWithNotNullStateName_then_ShouldReturnValidStateResponseModel() {
        when(stateRepository.save(any(State.class))).thenReturn(stateList.get(0));
        StateResponseModel stateResponseModel = stateService.createState(stateRequestModel.get(0));

        assertNotNull(stateResponseModel);
        assertNotNull(stateResponseModel.getStateId());
        assertEquals(stateResponseModel.getStateName(), stateRequestModel.get(0).getStateName());
    }

    @Test
    public void getAllStates_then_shouldReturnValidResponse() {
        when(stateRepository.findAll()).thenReturn(stateList);

        List<StateResponseModel> stateResponseModelList = stateService.getStates();

        assertNotNull(stateResponseModelList);
        assertEquals(stateList.size(), stateResponseModelList.size());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getAllStatesWithEmptyList_then_shouldThrowResourceNotFoundException() {
        List<State> stateList = Collections.emptyList();

        when(stateRepository.findAll()).thenReturn(stateList);

        stateService.getStates();
    }
}