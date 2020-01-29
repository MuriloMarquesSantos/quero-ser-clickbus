package com.clickbus.placesmanager.services.impl;

import com.clickbus.placesmanager.application.response.PlaceResponseModel;
import com.clickbus.placesmanager.entities.Place;
import com.clickbus.placesmanager.exception.ResourceNotFoundException;
import com.clickbus.placesmanager.repository.CityRepository;
import com.clickbus.placesmanager.repository.PlaceRepository;
import com.clickbus.placesmanager.services.PlaceServiceImpl;
import com.clickbus.placesmanager.services.impl.helper.CityServiceImplTestHelper;
import com.clickbus.placesmanager.services.impl.helper.PlaceServiceImplTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.clickbus.placesmanager.services.impl.helper.CityServiceImplTestHelper.*;
import static com.clickbus.placesmanager.services.impl.helper.PlaceServiceImplTestHelper.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlaceServiceImplTest {

    @InjectMocks
    private PlaceServiceImpl placeService;

    @Mock
    private PlaceRepository placeRepository;

    @Mock
    private CityRepository cityRepository;

    @Test
    public void createPlaceWithValidArguments_then_shouldReturnValidPlaceResponseModel() {
        when(cityRepository.findByCityId(anyString())).thenReturn(Optional.of(createValidCityEntity()));
        when(placeRepository.save(any(Place.class))).thenReturn(createValidPlaceEntity());

        PlaceResponseModel placeResponseModel = placeService.createPlace(createValidPlaceRequestModel());

        assertNotNull(placeResponseModel);
        assertNotNull(placeResponseModel.getSlug());
        assertNotNull(placeResponseModel.getCity());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void createPlaceWithInvalidState_then_shouldThrowResourceNotFoundException() {
        when(cityRepository.findByCityId(anyString())).thenReturn(Optional.empty());

        placeService.createPlace(createValidPlaceRequestModel());
    }

    @Test
    public void getAllPlaces_then_shouldReturnValidResponse() {
        List<Place> placeList = Arrays.asList(
                createValidPlaceEntity(), createValidPlaceEntity());

        when(placeRepository.findAll()).thenReturn(placeList);

        List<PlaceResponseModel> stateResponseModelList = placeService.getPlaces();

        assertNotNull(stateResponseModelList);
    }

}
