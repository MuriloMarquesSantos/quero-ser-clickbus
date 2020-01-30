package com.clickbus.placesmanager.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlaceRequestModel {

    @NotNull
    private String placeName;
    @NotNull
    private String cityId;

}
