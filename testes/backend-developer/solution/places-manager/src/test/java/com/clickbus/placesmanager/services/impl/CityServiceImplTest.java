package com.clickbus.placesmanager.services.impl;

import com.clickbus.placesmanager.repository.CityRepository;
import com.clickbus.placesmanager.services.CityServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceImplTest {

    @InjectMocks
    private CityServiceImpl cityService;

    @Mock
    private CityRepository cityRepository;

    @Test
    public void createCity() {
        assertNotNull(cityService.createCity());
    }

}
