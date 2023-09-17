package com.devAsk.api.mapper;

import com.devAsk.api.dto.response.UserDetailResponse;
import com.devAsk.api.dto.response.UserResponse;
import com.devAsk.api.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDetailResponse UserToUserDetailResponse(User user);

    UserResponse userToUserResponse(User user);


}
