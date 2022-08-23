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
            @Mapping(source = "admin_first_name", target = "admin_first_name"),
            @Mapping(source = "admin_last_name", target = "admin_last_name"),
            @Mapping(source = "admin_user_name", target = "admin_user_name"),
            @Mapping(source = "admin_email", target = "admin_email"),
            @Mapping(source = "admin_password", target = "admin_password")

    })
    AdminDto entityToDto(AdminEntity adminEntity);

    @Mappings({
            @Mapping(source = "admin_first_name", target = "admin_first_name"),
            @Mapping(source = "admin_last_name", target = "admin_last_name"),
            @Mapping(source = "admin_user_name", target = "admin_user_name"),
            @Mapping(source = "admin_email", target = "admin_email"),
            @Mapping(source = "admin_password", target = "admin_password")

    })
    AdminEntity dtoToEntity(AdminDto adminDto);
}

