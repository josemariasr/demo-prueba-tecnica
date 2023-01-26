package com.prueba.tecnica.app.utils;

import org.modelmapper.ModelMapper;

public class DtoUtils {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <T> T map(Object objectToConvert, Class<T> classToConvert) {
        return modelMapper.map(objectToConvert, classToConvert);
    }

}