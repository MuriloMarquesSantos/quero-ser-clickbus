package com.clickbus.placesmanager.services.impl.controllers;

import com.clickbus.placesmanager.controllers.CityController;
import com.clickbus.placesmanager.exception.ResponseExceptionHandler;
import com.clickbus.placesmanager.services.CityService;
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

import static com.clickbus.placesmanager.services.impl.helper.CityTestHelper.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class CityControllerClass {

    private MockMvc mockMvc;

    private ObjectMapper jsonObjectMapper;

    @InjectMocks
    private CityController cityController;

    @Mock
    private CityService cityService;


    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(cityController)
                .setControllerAdvice(new ResponseExceptionHandler())
                .build();
        jsonObjectMapper = new ObjectMapper();
    }

    @Test
    public void performGetCities_thenShouldReturnOkResponse() throws Exception {
        when(cityService.getCities()).thenReturn(createListOfValidCityResponseModel());

        mockMvc.perform(get(CityController.BASE_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void performCreateCitiesWithoutState_thenShouldThrowBadRequest() throws Exception {
        mockMvc.perform(post(CityController.BASE_PATH)
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonObjectMapper.writeValueAsString(createInvalidCityRequestModel())))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void performCreateCitiesWithValidRequest_thenShouldReturnCreateResponse() throws Exception {
        mockMvc.perform(post(CityController.BASE_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObjectMapper.writeValueAsString(createValidCityRequestModel())))
                .andExpect(status().isCreated());
    }

}
