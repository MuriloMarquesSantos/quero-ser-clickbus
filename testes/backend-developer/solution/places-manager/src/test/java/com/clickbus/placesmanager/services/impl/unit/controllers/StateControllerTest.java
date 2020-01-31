package com.clickbus.placesmanager.services.impl.unit.controllers;

import com.clickbus.placesmanager.controllers.StateController;
import com.clickbus.placesmanager.exception.ResponseExceptionHandler;
import com.clickbus.placesmanager.services.StateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.clickbus.placesmanager.services.impl.helper.StateTestHelper.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class StateControllerTest {

    private MockMvc mockMvc;

    private ObjectMapper jsonObjectMapper;

    @InjectMocks
    private StateController stateController;

    @Mock
    private StateService stateService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(stateController)
                .setControllerAdvice(new ResponseExceptionHandler())
                .build();
        jsonObjectMapper = new ObjectMapper();
    }

    @Test
    public void performGetStates_then_ShouldReturnOkResponse() throws Exception {
        when(stateService.getStates()).thenReturn(createListOfValidStateResponseModel());

        mockMvc.perform(get(StateController.BASE_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void performCreateStatesWithInvalidStateRequestModel_then_ShouldThrowBadRequest() throws Exception {
        mockMvc.perform(post(StateController.BASE_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObjectMapper.writeValueAsString(createInvalidStateRequestModel())))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void performCreateStates_then_returnOkResponse() throws Exception {
        mockMvc.perform(post(StateController.BASE_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObjectMapper.writeValueAsString(createValidStateRequestModel())))
                .andExpect(status().isCreated());
    }
}
