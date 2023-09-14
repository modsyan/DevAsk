package com.devAsk.api.service.impl;

import com.devAsk.api.exception.EntityNotFoundException;
import com.devAsk.api.entity.Question;
import com.devAsk.api.dto.request.CreateEditQuestionRequest;
import com.devAsk.api.dto.response.QuestionResponse;
import com.devAsk.api.mapper.QuestionMapper;
import com.devAsk.api.repository.QuestionRepository;
import com.devAsk.api.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    //TODO: NEED A Mapper Framework Here
    private final QuestionRepository _questionRepository;
    private final QuestionMapper _questionMapper;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        _questionRepository = questionRepository;
        _questionMapper = QuestionMapper.INSTANCE;
    }


    @Override
    public QuestionResponse GetDetails(long id) {
        Question question = _questionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post with this id Not Found."));
        return _questionMapper.PostToGetPostResponse(question);
    }

    @Override
    public List<QuestionResponse> GetAll() {
        return _questionRepository
                .findAll()
                .stream()
                .map(_questionMapper::PostToGetPostResponse)
                .collect(Collectors.toList());
    }

    @Override
    public QuestionResponse Create(CreateEditQuestionRequest dto) {
        Question question = QuestionMapper.INSTANCE.createEditPostRequestToPost(dto);
        //post.setUserId(authentication.getId()); //TODO: Taking the userID from the Celiams
        Question newQuestion = _questionRepository.save(question);
        return _questionMapper.PostToCreateEditPostResponse(newQuestion);
    }

    @Override
    public QuestionResponse Edit(long id, CreateEditQuestionRequest dto) {

        Question question = _questionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post with this ID not found"));
        question.setTitle(dto.getTitle());
        question.setContent(dto.getContent());
        //TODO: Trigger here if has media changed must remove all cascading images related with post_id

        Question updatedQuestion = _questionRepository.save(question);
        return _questionMapper.PostToCreateEditPostResponse(updatedQuestion);
    }

    @Override
    public void Delete(long id) {
        Question question = _questionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Failed, Post not found to deleted"));
        _questionRepository.delete(question);
    }
}
