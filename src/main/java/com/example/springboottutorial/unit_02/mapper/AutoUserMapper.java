package com.example.springboottutorial.unit_02.mapper;

import com.example.springboottutorial.unit_02.UserDto.UserDto;
import com.example.springboottutorial.unit_02.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDto mapUserToUserDto(User user);

    User mapUserDtoToUser(UserDto userDto);
}
