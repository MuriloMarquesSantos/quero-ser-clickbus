package com.clickbus.placesmanager.services.impl.unit.controllers;

import com.clickbus.placesmanager.controllers.PlaceController;
import com.clickbus.placesmanager.dto.request.PlaceRequestModel;
import com.clickbus.placesmanager.dto.response.PlaceResponseModel;
import com.clickbus.placesmanager.exception.ResponseExceptionHandler;
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

import java.util.List;

import static com.clickbus.placesmanager.controllers.PlaceController.BASE_PATH;
import static com.clickbus.placesmanager.services.impl.helper.CityTestHelper.createInvalidCityRequestModel;
import static com.clickbus.placesmanager.services.impl.helper.PlaceTestHelper.*;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(MockitoJUnitRunner.class)
public class PlaceControllerTest {

    private MockMvc mockMvc;

    private ObjectMapper jsonObjectMapper;

    @InjectMocks
    private PlaceController placeController;

    @Mock
    private PlaceService placeService;

    private static final String GET_PLACES_BY_ID_PATH = BASE_PATH.concat("/id/");
    private static final String UPDATE_PLACE_PATH = BASE_PATH.concat("/id/");

    private PlaceResponseModel placeResponseModel;

    private List<PlaceResponseModel> placeResponseModelList;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(placeController)
                .setControllerAdvice(new ResponseExceptionHandler())
                .build();

        jsonObjectMapper = new ObjectMapper();

        placeResponseModel = createValidPlaceResponseModel();

        placeResponseModelList = createListOfPlaceResponseModel();

    }

    @Test
    public void performGetPlaces_then_ShouldReturnOkResponse() throws Exception {
        when(placeService.getPlaces()).thenReturn(createListOfPlaceResponseModel());

        mockMvc.perform(get(BASE_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void performCreatePlaceWithoutState_then_ShouldThrowBadRequest() throws Exception {
        mockMvc.perform(post(BASE_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObjectMapper.writeValueAsString(createInvalidCityRequestModel())))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void performCreatePlaceWithValidRequest_then_ShouldReturnCreatedResponse() throws Exception {
        mockMvc.perform(post(BASE_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObjectMapper.writeValueAsString(createValidPlaceRequestModel())))
                .andExpect(status().isCreated());
    }

    @Test
    public void performGetPlaceByIdWithValidArguments_then_ShouldReturnOkResponse() throws Exception {
        when(placeService.getPlaceByPlaceId(anyString())).thenReturn(placeResponseModel);

        String placeId = createValidPlaceEntity().getPlaceId();

        mockMvc.perform(get(GET_PLACES_BY_ID_PATH.concat(placeId))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.placeId", equalTo(placeResponseModel.getPlaceId())));
    }

    @Test
    public void performGetPlaceByNameWithValidArguments_then_ShouldReturnOkResponse() throws Exception {
        when(placeService.getPlacesByPlaceName(anyString())).thenReturn(placeResponseModelList);

        String placeName = createValidPlaceEntity().getPlaceName();

        mockMvc.perform(get(BASE_PATH.concat("/" + placeName))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].placeName", equalTo(placeResponseModelList.get(0).getPlaceName())))
                .andExpect(jsonPath("$[0].placeId", equalTo(placeResponseModelList.get(0).getPlaceId())))
                .andExpect(jsonPath("$[0].slug", equalTo(placeResponseModelList.get(0).getSlug())))
                .andExpect(jsonPath("$[1].placeName", equalTo(placeResponseModelList.get(1).getPlaceName())));
    }

    @Test
    public void performUpdatePlaceWithValidArguments_then_shouldReturnOkResponse() throws Exception {
        when(placeService.updatePlace(anyString(), any(PlaceRequestModel.class))).thenReturn(placeResponseModel);

        String placeId = createValidPlaceEntity().getPlaceId();

        mockMvc.perform(put(UPDATE_PLACE_PATH.concat(placeId))
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObjectMapper.writeValueAsString(createValidPlaceRequestModel())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.placeName", equalTo(placeResponseModel.getPlaceName())))
                .andExpect(jsonPath("$.slug", equalTo(placeResponseModel.getSlug())));
    }

}
