package com.clickbus.placesmanager.services.impl;

import com.clickbus.placesmanager.application.requestmodels.StateRequestModel;
import com.clickbus.placesmanager.application.responsemodels.StateResponseModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class StateServiceImplTest {

    @InjectMocks
    private StateServiceImpl stateService;

    @Test
    public void createState() {
        StateResponseModel stateResponseModel = stateService.createState(StateRequestModel.builder().build());
        assertNotNull(stateResponseModel);
    }
}