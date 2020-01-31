package com.clickbus.placesmanager.services.impl.integration.repository;

import com.clickbus.placesmanager.entities.Place;
import com.clickbus.placesmanager.repository.PlaceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.clickbus.placesmanager.services.impl.helper.PlaceTestHelper.createValidPlaceEntity;
import static org.junit.Assert.assertNotNull;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PlaceRepositoryTest {

    @Autowired
    private PlaceRepository placeRepository;

    @Test
    public void createPlaceWithValidData_then_shouldPersistAndReturnValidPlace() {
        Place place = createValidPlaceEntity();
        place = placeRepository.save(place);

        assertNotNull(place.getId());
        assertNotNull(place.getPlaceName());
        assertNotNull(place.getCity());
    }

    @Test
    public void getPlacesWithValidRequest_then_shouldReturnValidPlaces() {
        List<Place> places = placeRepository.findAll();

        assertNotNull(places);
    }
}
