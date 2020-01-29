package com.clickbus.placesmanager.services.impl;

import com.clickbus.placesmanager.application.response.StateResponseModel;
import com.clickbus.placesmanager.entities.State;
import com.clickbus.placesmanager.repository.StateRepository;
import com.clickbus.placesmanager.services.StateServiceImpl;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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


    @Test
    public void createStateWithNotNullStateName_then_ShouldReturnValidStateResponseModel() {
        when(stateRepository.save(any(State.class))).thenReturn(createValidStateEntity());
        StateResponseModel stateResponseModel = stateService.createState(createValidStateRequestModel());

        assertNotNull(stateResponseModel);
        assertNotNull(stateResponseModel.getStateName());
        assertNotNull(stateResponseModel.getStateId());
    }

    @Test
    public void getAllStates_then_shouldReturnValidResponse() {
        List<State> stateList = Arrays.asList(
                State.builder().stateName(faker.address().state()).build(),
                State.builder().stateName(faker.address().state()).build());

        when(stateRepository.findAll()).thenReturn(stateList);

        List<StateResponseModel> stateResponseModelList = stateService.getStates();

        assertNotNull(stateResponseModelList);
        assertEquals(stateList.size(), stateResponseModelList.size());
    }

    @Test(expected = RuntimeException.class)
    public void getAllStatesWithEmptyList_then_shouldThrowRunTimeException() {
        List<State> stateList = Collections.emptyList();

        when(stateRepository.findAll()).thenReturn(stateList);

        stateService.getStates();
    }
}