package com.example.design.project.mapper;

import com.example.design.project.dao.entity.RoleEntity;
import com.example.design.project.model.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    @Mappings({
            @Mapping(source = "roleName", target = "roleName")
    })
    RoleDto entityToDto(RoleEntity roleEntity);

    @Mappings({
            @Mapping(source = "roleName", target = "roleName")
    })
    RoleEntity dtoToEntity(RoleDto roleDto);
}
