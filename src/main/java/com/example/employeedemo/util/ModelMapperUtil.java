package com.example.employeedemo.util;

import org.modelmapper.ModelMapper;

/**
 * @author Momen Magdy
 * Singleton ModelMapperUtil Class
 */
public class ModelMapperUtil {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static ModelMapper MAPPER() {
        return modelMapper;
    }
}
