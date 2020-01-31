package com.clickbus.placesmanager.services.impl.unit.services;

import com.clickbus.placesmanager.dto.request.PlaceRequestModel;
import com.clickbus.placesmanager.dto.response.PlaceResponseModel;
import com.clickbus.placesmanager.entities.Place;
import com.clickbus.placesmanager.exception.ResourceNotFoundException;
import com.clickbus.placesmanager.repository.CityRepository;
import com.clickbus.placesmanager.repository.PlaceRepository;
import com.clickbus.placesmanager.services.PlaceServiceImpl;
import com.clickbus.placesmanager.utils.ModelMapperFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.clickbus.placesmanager.services.impl.helper.CityTestHelper.createValidCityEntity;
import static com.clickbus.placesmanager.services.impl.helper.PlaceTestHelper.createListOfValidPlaceEntity;
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

    private List<Place> placeList;
    private List<PlaceRequestModel> requestModels;

    @Before
    public void setUp() {
        ModelMapper modelMapper = ModelMapperFactory.getInstance();
        placeList = createListOfValidPlaceEntity();

        requestModels = placeList
                .stream()
                .map(place -> modelMapper.map(place, PlaceRequestModel.class))
                .collect(Collectors.toList());
    }

    @Test
    public void createPlaceWithValidArguments_then_shouldReturnValidPlaceResponseModel() {
        when(cityRepository.findByCityId(anyString())).thenReturn(Optional.of(createValidCityEntity()));
        when(placeRepository.save(any(Place.class))).thenReturn(placeList.get(0));

        PlaceResponseModel placeResponseModel = placeService.createPlace(requestModels.get(0));

        assertNotNull(placeResponseModel);
        assertEquals(placeList.get(0).getSlug(), placeResponseModel.getSlug());
        assertNotNull(placeResponseModel.getCity());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void createPlaceWithInvalidState_then_shouldThrowResourceNotFoundException() {
        when(cityRepository.findByCityId(anyString())).thenReturn(Optional.empty());

        placeService.createPlace(requestModels.get(1));
    }

    @Test
    public void getAllPlaces_then_shouldReturnValidResponse() {
        when(placeRepository.findAll()).thenReturn(placeList);

        List<PlaceResponseModel> placeResponseModels = placeService.getPlaces();

        assertEquals(placeList.size(), placeResponseModels.size());
        assertNotNull(placeResponseModels);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getAllPlacesWithEmptyList_then_shouldThrowResourceNotFoundException() {
        List<Place> placeList = Collections.emptyList();

        when(placeRepository.findAll()).thenReturn(placeList);

        placeService.getPlaces();
    }

    @Test
    public void getPlaceByValidPlaceId_then_shouldReturnValidPlaceResponseModel() {
        when(placeRepository.findByPlaceId(anyString())).thenReturn(Optional.of(placeList.get(1)));

        PlaceResponseModel placeResponseModel = placeService.getPlaceByPlaceId("123");

        assertNotNull(placeResponseModel);
        assertEquals(placeList.get(1).getPlaceName(), placeResponseModel.getPlaceName());
        assertEquals(placeList.get(1).getSlug(), placeResponseModel.getSlug());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getPlaceByInvalidPlaceId_then_shouldThrowResourceNotFoundException() {
        when(placeRepository.findByPlaceId(anyString())).thenReturn(Optional.empty());

        placeService.getPlaceByPlaceId("123");
    }

    @Test
    public void getPlaceByValidPlaceName_then_shouldReturnValidPlaceResponseModel() {
        when(placeRepository.findAllByPlaceName("Place x")).thenReturn(placeList);

        List<PlaceResponseModel> stateResponseModelList = placeService.getPlacesByPlaceName("Place x");

        assertEquals(placeList.size(), stateResponseModelList.size());
        assertNotNull(stateResponseModelList);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getPlacesByInvalidPlaceName_then_shouldThrowResourceNotFoundException() {
        List<Place> placeList = Collections.emptyList();

        when(placeRepository.findAllByPlaceName("Place x")).thenReturn(placeList);

        placeService.getPlacesByPlaceName("Place x");
    }

    @Test
    public void updatePlaceWithValidPlaceId_then_ShouldReturnValidPlaceResponseModel() {
        when(cityRepository.findByCityId(anyString())).thenReturn(Optional.of(createValidCityEntity()));
        when(placeRepository.findByPlaceId(anyString())).thenReturn(Optional.of(placeList.get(0)));
        when(placeRepository.save(any(Place.class))).thenReturn(placeList.get(0));

        PlaceResponseModel placeResponseModel = placeService.updatePlace(placeList.get(0).getPlaceId(), requestModels.get(0));

        assertNotNull(placeResponseModel);
        assertEquals(placeList.get(0).getPlaceName(), placeResponseModel.getPlaceName());
        assertEquals(placeList.get(0).getSlug(), placeResponseModel.getSlug());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void updatePlaceWithInValidPlaceId_then_shouldThrowResourceNotFoundException() {
        when(placeRepository.findByPlaceId(anyString())).thenReturn(Optional.empty());

        placeService.updatePlace(placeList.get(0).getPlaceId(), requestModels.get(0));
    }
}
