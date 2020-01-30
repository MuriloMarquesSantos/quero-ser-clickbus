package com.clickbus.placesmanager.controllers;

import com.clickbus.placesmanager.dto.request.StateRequestModel;
import com.clickbus.placesmanager.dto.response.StateResponseModel;
import com.clickbus.placesmanager.services.StateService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("states")
public class StateController {

    private StateService stateService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StateResponseModel createState(@RequestBody @Valid StateRequestModel stateRequestModel) {
        return this.stateService.createState(stateRequestModel);
    }

    @GetMapping
    public List<StateResponseModel> getStates() {
        return stateService.getStates();
    }


}