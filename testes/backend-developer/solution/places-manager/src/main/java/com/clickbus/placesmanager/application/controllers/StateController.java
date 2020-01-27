package com.clickbus.placesmanager.application.controllers;

import com.clickbus.placesmanager.application.requestmodels.StateRequestModel;
import com.clickbus.placesmanager.application.responsemodels.StateResponseModel;
import com.clickbus.placesmanager.services.StateService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("states")
public class StateController {

    private StateService stateService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StateResponseModel createState(@RequestBody StateRequestModel stateRequestModel) {
        return this.stateService.createState(stateRequestModel);
    }


}
