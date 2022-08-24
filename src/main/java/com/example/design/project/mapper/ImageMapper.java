package com.example.design.project.mapper;

import com.example.design.project.dao.entity.ImageEntity;
import com.example.design.project.model.ImageDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ImageMapper {

    ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);

    @Mappings({
            @Mapping(source = "image_name", target = "image_name"),
            @Mapping(source = "image_file", target = "image_file")
    })
    ImageDto entityToDto(ImageEntity imageEntity);

    @Mappings({
            @Mapping(source = "image_name", target = "image_name"),
            @Mapping(source = "image_file", target = "image_file")
    })
    ImageEntity dtoToEntity(ImageDto imageDto);
}
