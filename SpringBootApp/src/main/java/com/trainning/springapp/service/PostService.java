package com.trainning.springapp.service;

import com.trainning.springapp.dto.requset.CreateEditPostRequest;
import com.trainning.springapp.dto.response.PostResponse;

import java.util.List;

public interface PostService {

    PostResponse GetDetails(long id);

    List<PostResponse> GetAll();

    PostResponse Create(CreateEditPostRequest dto);

    PostResponse Edit(long id, CreateEditPostRequest dto);

    void Delete(long id);
}
