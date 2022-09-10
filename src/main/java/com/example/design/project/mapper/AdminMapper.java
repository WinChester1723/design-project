package com.example.design.project.mapper;

import com.example.design.project.dao.entity.AdminEntity;
import com.example.design.project.model.AdminDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {
    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    @Mappings({
            @Mapping(source = "adminFirstName", target = "adminFirstName"),
            @Mapping(source = "adminLastName", target = "adminLastName"),
            @Mapping(source = "adminUserName", target = "adminUserName"),
            @Mapping(source = "adminEmail", target = "adminEmail"),
            @Mapping(source = "adminPassword", target = "adminPassword")

    })
    AdminDto entityToDto(AdminEntity adminEntity);

    @Mappings({
            @Mapping(source = "adminFirstName", target = "adminFirstName"),
            @Mapping(source = "adminLastName", target = "adminLastName"),
            @Mapping(source = "adminUserName", target = "adminUserName"),
            @Mapping(source = "adminEmail", target = "adminEmail"),
            @Mapping(source = "adminPassword", target = "adminPassword")

    })
    AdminEntity dtoToEntity(AdminDto adminDto);
}

