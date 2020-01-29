package com.clickbus.placesmanager.services.impl;

import com.clickbus.placesmanager.application.response.CityResponseModel;
import com.clickbus.placesmanager.application.response.StateResponseModel;
import com.clickbus.placesmanager.entities.City;
import com.clickbus.placesmanager.entities.State;
import com.clickbus.placesmanager.exception.ResourceNotFoundException;
import com.clickbus.placesmanager.repository.CityRepository;
import com.clickbus.placesmanager.repository.StateRepository;
import com.clickbus.placesmanager.services.CityServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.clickbus.placesmanager.services.impl.helper.CityServiceImplTestHelper.createValidCityEntity;
import static com.clickbus.placesmanager.services.impl.helper.CityServiceImplTestHelper.createValidCityRequestModel;
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

    private static final List<String> VALID_CITY_NAMES = Arrays.asList("São Paulo", "Rio de Janeiro");

    @Test
    public void createCityWithValidNameAndValidState_then_shouldReturnValidCityResponseModel() {
        when(stateRepository.findByStateId(anyString())).thenReturn(Optional.of(createValidStateEntity()));
        when(cityRepository.save(any(City.class))).thenReturn(createValidCityEntity());

        CityResponseModel cityResponseModel = cityService.createCity(createValidCityRequestModel());

        assertNotNull(cityResponseModel);
        assertNotNull(cityResponseModel.getCityName());
        assertNotNull(cityResponseModel.getCityId());
        assertEquals(cityResponseModel.getCityName(), createValidCityRequestModel().getCityName());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void createCityWithInvalidState_then_shouldThrowResourceNotFoundException() {
        when(stateRepository.findByStateId(anyString())).thenReturn(Optional.empty());

        cityService.createCity(createValidCityRequestModel());
    }

    @Test
    public void getAllCities_then_shouldReturnValidResponse() {
        List<City> cityList = Arrays.asList(
                City.builder().cityName(VALID_CITY_NAMES.get(0)).build(),
                City.builder().cityName(VALID_CITY_NAMES.get(1)).build());

        when(cityRepository.findAll()).thenReturn(cityList);

        List<CityResponseModel> cityResponseModelList = cityService.getCities();

        assertNotNull(cityResponseModelList);
        assertEquals(VALID_CITY_NAMES.size(), cityResponseModelList.size());
    }

    @Test(expected = RuntimeException.class)
    public void getAllCitiesWithEmptyList_then_shouldThrowRuntimeException() {
        List<City> cityList = Collections.emptyList();

        when(cityRepository.findAll()).thenReturn(cityList);

        cityService.getCities();
    }
}
