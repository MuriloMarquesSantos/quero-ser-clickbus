package com.clickbus.placesmanager.services.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceImplTest {

    @InjectMocks
    private CityServiceImpl cityService;

    @Test
    public void createCity() {
        assertNotNull(cityService.createCity());
    }

}
