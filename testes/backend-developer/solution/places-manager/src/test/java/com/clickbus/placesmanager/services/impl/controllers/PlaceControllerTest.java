package com.clickbus.placesmanager.services.impl.controllers;

import com.clickbus.placesmanager.controllers.CityController;
import com.clickbus.placesmanager.controllers.PlaceController;
import com.clickbus.placesmanager.exception.ResponseExceptionHandler;
import com.clickbus.placesmanager.services.CityService;
import com.clickbus.placesmanager.services.PlaceService;
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
import static com.clickbus.placesmanager.services.impl.helper.PlaceTestHelper.createListOfPlaceResponseModel;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class PlaceControllerTest {

    private MockMvc mockMvc;

    private ObjectMapper jsonObjectMapper;

    @InjectMocks
    private PlaceController placeController;

    @Mock
    private PlaceService placeService;


    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(placeController)
                .setControllerAdvice(new ResponseExceptionHandler())
                .build();
        jsonObjectMapper = new ObjectMapper();
    }

    @Test
    public void performGetPlaces_then_ShouldReturnOkResponse() throws Exception {
        when(placeService.getPlaces()).thenReturn(createListOfPlaceResponseModel());

        mockMvc.perform(get(PlaceController.BASE_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void performCreatePlaceWithoutState_then_ShouldThrowBadRequest() throws Exception {
        mockMvc.perform(post(PlaceController.BASE_PATH)
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonObjectMapper.writeValueAsString(createInvalidCityRequestModel())))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void performCreateCitiesWithValidRequest_then_ShouldReturnCreateResponse() throws Exception {
        mockMvc.perform(post(CityController.BASE_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObjectMapper.writeValueAsString(createValidCityRequestModel())))
                .andExpect(status().isCreated());
    }

}
