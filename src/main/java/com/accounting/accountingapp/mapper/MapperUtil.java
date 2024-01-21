package com.accounting.accountingapp.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class MapperUtil {

    private final ModelMapper modelMapper;

    public MapperUtil(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T> T convert(Object objectToBeConverted, T convertedObject) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(objectToBeConverted, (Type) convertedObject.getClass());
    }

}
//    private final ModelMapper modelMapper;
//
//    public MapperUtil(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }
//
//    public <T> T convertToEntity(T dto){
//        return (T) modelMapper.map(dto, Object.class);
//    }
//
//    public <T> T convertToDto(T entity){
//        return (T) modelMapper.map(entity, Object.class);
//
