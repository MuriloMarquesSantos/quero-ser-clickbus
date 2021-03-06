package com.clickbus.placesmanager.controllers;

import com.clickbus.placesmanager.dto.request.PlaceRequestModel;
import com.clickbus.placesmanager.dto.response.PlaceResponseModel;
import com.clickbus.placesmanager.services.PlaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.clickbus.placesmanager.controllers.PlaceController.BASE_PATH;

@AllArgsConstructor
@RestController
@RequestMapping(BASE_PATH)
public class PlaceController {

    private PlaceService placeService;

    public static final String BASE_PATH = "/places";

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

    @PutMapping("id/{placeId}")
    @ResponseStatus(HttpStatus.OK)
    public PlaceResponseModel updatePlace(@PathVariable String placeId,
                                          @RequestBody @Valid PlaceRequestModel placeRequestModel) {
        return this.placeService.updatePlace(placeId, placeRequestModel);
    }

}
