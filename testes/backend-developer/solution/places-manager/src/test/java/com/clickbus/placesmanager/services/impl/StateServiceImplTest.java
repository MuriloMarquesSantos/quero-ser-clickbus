package com.clickbus.placesmanager.services.impl;

import com.clickbus.placesmanager.application.response.StateResponseModel;
import com.clickbus.placesmanager.entities.State;
import com.clickbus.placesmanager.repository.StateRepository;
import com.clickbus.placesmanager.services.StateServiceImpl;
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

    private static final List<String> VALID_STATE_NAMES = Arrays.asList("RJ", "SP");

    @Test
    public void createStateWithNotNullStateName_then_ShouldReturnValidStateResponseModel() {
        when(stateRepository.save(any(State.class))).thenReturn(createValidStateEntity());
        StateResponseModel stateResponseModel = stateService.createState(createValidStateRequestModel());
        assertNotNull(stateResponseModel);
        assertEquals(VALID_STATE_NAMES.get(0), stateResponseModel.getStateName());
    }

    @Test
    public void getAllStates_then_shouldReturnValidResponse() {
        List<State> stateList = Arrays.asList(
                State.builder().stateName(VALID_STATE_NAMES.get(0)).build(),
                State.builder().stateName(VALID_STATE_NAMES.get(1)).build());

        when(stateRepository.findAll()).thenReturn(stateList);

        List<StateResponseModel> stateResponseModelList = stateService.getStates();

        assertNotNull(stateResponseModelList);
        assertEquals(VALID_STATE_NAMES.size(), stateResponseModelList.size());
    }

    @Test(expected = RuntimeException.class)
    public void getAllStatesWithEmptyList_then_shouldThrowRunTimeException() {
        List<State> stateList = Collections.emptyList();

        when(stateRepository.findAll()).thenReturn(stateList);

        stateService.getStates();
    }
}