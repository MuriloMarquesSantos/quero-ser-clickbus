package com.clickbus.placesmanager.application.controllers;

import com.clickbus.placesmanager.application.request.PlaceRequestModel;
import com.clickbus.placesmanager.application.response.PlaceResponseModel;
import com.clickbus.placesmanager.services.PlaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("places")
public class PlaceController {

    private PlaceService placeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlaceResponseModel createState(@RequestBody @Valid PlaceRequestModel placeRequestModel) {
        return this.placeService.createPlace(placeRequestModel);
    }
}
