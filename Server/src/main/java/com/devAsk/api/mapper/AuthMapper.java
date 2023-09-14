package com.devAsk.api.mapper;

import com.devAsk.api.dto.request.RegisterUserRequest;
import com.devAsk.api.dto.response.AuthUserResponse;
import com.devAsk.api.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthMapper {
    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);

    User RegisterUserRequestToUser(RegisterUserRequest dto);

    AuthUserResponse UserToAuthUserResponse(User user);

}