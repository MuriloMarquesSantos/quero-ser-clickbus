package com.clickbus.placesmanager.controllers;

import com.clickbus.placesmanager.dto.request.CityRequestModel;
import com.clickbus.placesmanager.dto.response.CityResponseModel;
import com.clickbus.placesmanager.services.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CityResponseModel> getCities() {
        return this.cityService.getCities();
    }
}
