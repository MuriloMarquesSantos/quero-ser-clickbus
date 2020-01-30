package com.clickbus.placesmanager.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CityRequestModel {

    @NotNull
    private String cityName;
    @NotNull
    private String stateId;
}
