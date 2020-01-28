package com.clickbus.placesmanager.application.controllers;

import com.clickbus.placesmanager.application.request.CityRequestModel;
import com.clickbus.placesmanager.application.response.CityResponseModel;
import com.clickbus.placesmanager.services.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("cities")
public class CityController {

    private CityService cityService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CityResponseModel createCity(@RequestBody @Valid CityRequestModel cityRequestModel) {
        return this.cityService.createCity(cityRequestModel);
    }
}
