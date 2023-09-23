package com.devAsk.api.mapper;

import com.devAsk.api.dto.request.RegisterUserRequest;
import com.devAsk.api.dto.response.AuthUserResponse;
import com.devAsk.api.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface AuthMapper {
    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);

    User RegisterUserRequestToUser(RegisterUserRequest dto);

    AuthUserResponse UserToAuthUserResponse(User user);

}