package com.trainning.springapp.service.impl;

import com.trainning.springapp.dto.requset.CreateEditPostRequest;
import com.trainning.springapp.dto.response.PostResponse;
import com.trainning.springapp.exception.EntityNotFoundException;
import com.trainning.springapp.mapper.PostMapper;
import com.trainning.springapp.model.Post;
import com.trainning.springapp.repository.PostRepository;
import com.trainning.springapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    //TODO: NEED A Mapper Framework Here
    private final PostRepository _postRepository;
    private final PostMapper _postMapper;

    @Autowired
    public PostServiceImpl(PostRepository _postRepository) {
        this._postRepository = _postRepository;
        _postMapper = PostMapper.INSTANCE;
    }


    @Override
    public PostResponse GetDetails(long id) {
        Post post = _postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post with this id Not Found."));
        return _postMapper.PostToGetPostResponse(post);
    }

    @Override
    public List<PostResponse> GetAll() {
        return _postRepository
                .findAll()
                .stream()
                .map(_postMapper::PostToGetPostResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PostResponse Create(CreateEditPostRequest dto) {
        Post post = PostMapper.INSTANCE.createEditPostRequestToPost(dto);
        //post.setUserId(authentication.getId()); //TODO: Taking the userID from the Celiams
        Post newPost = _postRepository.save(post);
        return _postMapper.PostTocreateEditPostResponse(newPost);
    }

    @Override
    public PostResponse Edit(long id, CreateEditPostRequest dto) {

        Post post = _postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post with this ID not found"));
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setHasMedia(dto.isHasMedia());
        //TODO: Trigger here if has media changed must remove all cascading images related with post_id

        Post updatedPost = _postRepository.save(post);
        return _postMapper.PostTocreateEditPostResponse(updatedPost);
    }

    @Override
    public void Delete(long id) {
        Post post = _postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Failed, Post not found to deleted"));
        _postRepository.delete(post);
    }
}
