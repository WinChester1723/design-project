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
            @Mapping(source = "imageName", target = "imageName"),
            @Mapping(source = "imageFile", target = "imageFile")
    })
    ImageDto entityToDto(ImageEntity imageEntity);

    @Mappings({
            @Mapping(source = "imageName", target = "imageName"),
            @Mapping(source = "imageFile", target = "imageFile")
    })
    ImageEntity dtoToEntity(ImageDto imageDto);
}
