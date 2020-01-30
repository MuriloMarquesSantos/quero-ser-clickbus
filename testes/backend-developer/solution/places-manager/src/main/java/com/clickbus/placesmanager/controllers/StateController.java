package com.clickbus.placesmanager.controllers;

import com.clickbus.placesmanager.dto.request.StateRequestModel;
import com.clickbus.placesmanager.dto.response.StateResponseModel;
import com.clickbus.placesmanager.services.StateService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.clickbus.placesmanager.controllers.StateController.BASE_PATH;

@AllArgsConstructor
@RestController
@RequestMapping(BASE_PATH)
public class StateController {

    private StateService stateService;

    public final static String BASE_PATH = "/states";

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
