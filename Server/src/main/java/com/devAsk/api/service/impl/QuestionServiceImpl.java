package com.devAsk.api.service.impl;

import com.devAsk.api.entity.User;
import com.devAsk.api.exception.EntityNotFoundException;
import com.devAsk.api.entity.Question;
import com.devAsk.api.dto.request.CreateEditQuestionRequest;
import com.devAsk.api.dto.response.QuestionResponse;
import com.devAsk.api.mapper.QuestionMapper;
import com.devAsk.api.repository.QuestionRepository;
import com.devAsk.api.service.QuestionService;
import com.devAsk.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    //TODO: NEED A Mapper Framework Here
    private final QuestionRepository _questionRepository;
    private final QuestionMapper _questionMapper;
    private final UserService userService;

//    @Autowired
//    public QuestionServiceImpl(QuestionRepository questionRepository, UserService userService) {
//        _questionRepository = questionRepository;
//        this.userService = userService;
//        _questionMapper = QuestionMapper.INSTANCE;
//    }


    @Override
    public QuestionResponse GetDetails(long id) {
        Question question = _questionRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post with this id Not Found."));
        return _questionMapper.questionToQuestionResponse(question);
    }

    @Override
    public List<QuestionResponse> GetAll(Pageable pageable) {
        return _questionRepository
                .findAll(pageable)
                .getContent()
                .stream()
                .map(_questionMapper::questionToQuestionResponse)
                .collect(Collectors.toList());
    }

    @Override
    public QuestionResponse Create(CreateEditQuestionRequest dto) {
        Question question = QuestionMapper.INSTANCE.createEditPostRequestToPost(dto);

        User user = (User) userService
                .userDetailsService()
                .loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        question.setUser(user);
        Question newQuestion = _questionRepository.save(question);
        return _questionMapper.questionToCreateEditQuestionResponse(newQuestion);
    }

    @Override
    public QuestionResponse Edit(long id, CreateEditQuestionRequest dto) {

        Question question = _questionRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post with this ID not found"));
        question.setTitle(dto.getTitle());
        question.setContent(dto.getContent());
        //TODO: Trigger here if has media changed must remove all cascading images related with post_id

        Question updatedQuestion = _questionRepository.save(question);
        return _questionMapper.questionToCreateEditQuestionResponse(updatedQuestion);
    }

    @Override
    public void Delete(long id) {
        Question question = _questionRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Failed, Question not found to deleted"));
        _questionRepository.delete(question);
    }
}
