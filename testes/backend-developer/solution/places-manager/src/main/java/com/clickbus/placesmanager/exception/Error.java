package com.clickbus.placesmanager.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Error {

    private String message;
}
