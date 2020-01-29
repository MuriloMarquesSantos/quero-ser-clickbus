package com.clickbus.placesmanager.application.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CityRequestModel {

    @NotNull
    private String cityName;
    @NotNull
    private String stateId;
}
