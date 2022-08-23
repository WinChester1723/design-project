package com.example.design.project.mapper;

import com.example.design.project.dao.entity.UserRegisterEntity;
import com.example.design.project.model.UserRegisterDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserRegisterMapper {
    UserRegisterMapper INSTANCE = Mappers.getMapper(UserRegisterMapper.class);

    @Mappings({
            @Mapping(source = "first_name", target = "first_name"),
            @Mapping(source = "last_name", target = "last_name"),
            @Mapping(source = "user_name", target = "user_name"),
            @Mapping(source = "user_email", target = "user_email"),
            @Mapping(source = "user_password", target = "user_password")

    })
    UserRegisterDto entityToDto(UserRegisterEntity userRegisterEntity);

    @Mappings({
            @Mapping(source = "first_name", target = "first_name"),
            @Mapping(source = "last_name", target = "last_name"),
            @Mapping(source = "user_name", target = "user_name"),
            @Mapping(source = "user_email", target = "user_email"),
            @Mapping(source = "user_password", target = "user_password")

    })
    UserRegisterEntity dtoToEntity(UserRegisterDto userRegisterDto);
}
