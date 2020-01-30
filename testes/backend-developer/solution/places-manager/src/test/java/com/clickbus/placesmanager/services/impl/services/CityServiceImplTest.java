package com.clickbus.placesmanager.services.impl.services;

import com.clickbus.placesmanager.dto.request.CityRequestModel;
import com.clickbus.placesmanager.dto.request.StateRequestModel;
import com.clickbus.placesmanager.dto.response.CityResponseModel;
import com.clickbus.placesmanager.entities.City;
import com.clickbus.placesmanager.exception.ResourceNotFoundException;
import com.clickbus.placesmanager.repository.CityRepository;
import com.clickbus.placesmanager.repository.StateRepository;
import com.clickbus.placesmanager.services.CityServiceImpl;
import com.clickbus.placesmanager.utils.ModelMapperFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.clickbus.placesmanager.services.impl.helper.CityServiceImplTestHelper.*;
import static com.clickbus.placesmanager.services.impl.helper.StateServiceImplTestHelper.createListOfValidStateEntity;
import static com.clickbus.placesmanager.services.impl.helper.StateServiceImplTestHelper.createValidStateEntity;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceImplTest {

    @Mock
    private CityRepository cityRepository;

    @Mock
    private StateRepository stateRepository;

    @InjectMocks
    private CityServiceImpl cityService;

    private List<City> cityList;
    private List<CityRequestModel> cityRequestModels;

    @Before
    public void setUp() {
        ModelMapper modelMapper = ModelMapperFactory.getInstance();
        cityList = createListOfValidCityEntity();

        cityRequestModels = cityList
                .stream()
                .map(city -> modelMapper.map(city, CityRequestModel.class))
                .collect(Collectors.toList());
    }

    @Test
    public void createCityWithValidNameAndValidState_then_shouldReturnValidCityResponseModel() {
        when(stateRepository.findByStateId(anyString())).thenReturn(Optional.of(createValidStateEntity()));
        when(cityRepository.save(any(City.class))).thenReturn(cityList.get(0));

        CityResponseModel cityResponseModel = cityService.createCity(cityRequestModels.get(0));

        assertNotNull(cityResponseModel);
        assertEquals(cityList.get(0).getCityName(), cityResponseModel.getCityName());
        assertEquals(cityList.get(0).getCityId(), cityResponseModel.getCityId());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void createCityWithInvalidState_then_shouldThrowResourceNotFoundException() {
        when(stateRepository.findByStateId(anyString())).thenReturn(Optional.empty());

        cityService.createCity(cityRequestModels.get(1));
    }

    @Test
    public void getAllCities_then_shouldReturnValidResponse() {
        when(cityRepository.findAll()).thenReturn(cityList);

        List<CityResponseModel> cityResponseModelList = cityService.getCities();

        assertNotNull(cityResponseModelList);
        assertEquals(cityList.size(), cityResponseModelList.size());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getAllCitiesWithEmptyList_then_shouldThrowResourceNotFoundException() {
        List<City> cityList = Collections.emptyList();

        when(cityRepository.findAll()).thenReturn(cityList);

        cityService.getCities();
    }
}
