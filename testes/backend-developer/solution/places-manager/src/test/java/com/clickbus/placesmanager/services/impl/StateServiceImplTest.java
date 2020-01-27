package com.clickbus.placesmanager.services.impl;

import com.clickbus.placesmanager.application.requestmodels.StateRequestModel;
import com.clickbus.placesmanager.application.responsemodels.StateResponseModel;
import com.clickbus.placesmanager.entities.State;
import com.clickbus.placesmanager.repository.StateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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

    @Test
    public void createState() {
        State stateEntity = State.builder().stateName("RJ").build();
        when(stateRepository.save(any(State.class))).thenReturn(stateEntity);
        StateResponseModel stateResponseModel = stateService.createState(StateRequestModel.
                builder().
                stateName("RJ").build());
        assertNotNull(stateResponseModel);
        assertEquals("RJ", stateResponseModel.getStateName());
    }
}