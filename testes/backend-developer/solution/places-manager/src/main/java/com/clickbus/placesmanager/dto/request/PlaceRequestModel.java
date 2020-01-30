package com.clickbus.placesmanager.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PlaceRequestModel {

    @NotNull
    private String placeName;
    @NotNull
    private String cityId;

}