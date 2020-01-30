package com.clickbus.placesmanager.utils;

import org.modelmapper.ModelMapper;

import java.util.Optional;

public class ModelMapperFactory {

    private static ModelMapper modelMapper;

    private ModelMapperFactory(){}

    public static ModelMapper getInstance() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }
        return modelMapper;
    }
}
