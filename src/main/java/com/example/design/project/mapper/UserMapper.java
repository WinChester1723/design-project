package com.example.design.project.mapper;

import com.example.design.project.dao.entity.UserEntity;
import com.example.design.project.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "userName", target = "userName"),
            @Mapping(source = "userEmail", target = "userEmail"),
            @Mapping(source = "userPassword", target = "userPassword")

    })
    UserDto entityToDto(UserEntity userEntity);

    @Mappings({
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "userName", target = "userName"),
            @Mapping(source = "userEmail", target = "userEmail"),
            @Mapping(source = "userPassword", target = "userPassword")

    })
    UserEntity dtoToEntity(UserDto userDto);
}
