package com.trainning.springapp.mapper;


import com.trainning.springapp.dto.requset.CreateEditPostRequest;
import com.trainning.springapp.dto.response.PostResponse;
import com.trainning.springapp.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    Post createEditPostRequestToPost(CreateEditPostRequest dto);

    PostResponse PostTocreateEditPostResponse(Post post);

    PostResponse PostToGetPostResponse(Post post);
}