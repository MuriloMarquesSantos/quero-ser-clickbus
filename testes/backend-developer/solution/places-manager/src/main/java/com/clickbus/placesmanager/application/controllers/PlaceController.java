package com.clickbus.placesmanager.application.controllers;

import com.clickbus.placesmanager.application.request.PlaceRequestModel;
import com.clickbus.placesmanager.application.response.PlaceResponseModel;
import com.clickbus.placesmanager.services.PlaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("places")
public class PlaceController {

    private PlaceService placeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlaceResponseModel createPlace(@RequestBody @Valid PlaceRequestModel placeRequestModel) {
        return this.placeService.createPlace(placeRequestModel);
    }

    @GetMapping("id/{placeId}")
    @ResponseStatus(HttpStatus.OK)
    public PlaceResponseModel getPlaceByPlaceId(@PathVariable String placeId) {
        return this.placeService.getPlaceByPlaceId(placeId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PlaceResponseModel> getPlaces() {
        return this.placeService.getPlaces();
    }

    @GetMapping({"{placeName}"})
    @ResponseStatus(HttpStatus.OK)
    public List<PlaceResponseModel> getPlaceByPlaceName(@PathVariable String placeName) {
        return this.placeService.getPlacesByPlaceName(placeName);
    }

}
