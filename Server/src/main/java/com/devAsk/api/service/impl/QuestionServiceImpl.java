package com.devAsk.api.service.impl;

import com.devAsk.api.dto.request.QuestionRequest;
import com.devAsk.api.dto.response.QuestionDetailResponse;
import com.devAsk.api.entity.User;
import com.devAsk.api.exception.EntityNotFoundException;
import com.devAsk.api.entity.Question;
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
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;
    private final UserService userService;

//    @Autowired
//    public QuestionServiceImpl(QuestionRepository questionRepository, UserService userService) {
//        _questionRepository = questionRepository;
//        this.userService = userService;
//        _questionMapper = QuestionMapper.INSTANCE;
//    }


    @Override
    public QuestionDetailResponse getDetails(long id) {
        Question question = questionRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post with this id Not Found."));
        return questionMapper.questionToResponseDetail(question);
    }

    @Override
    public List<QuestionResponse> getAll(Pageable pageable) {
        return questionRepository
                .findAll(pageable)
                .getContent()
                .stream()
                .map(questionMapper::questionToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public QuestionResponse create(QuestionRequest dto) {
        Question question = QuestionMapper.INSTANCE.requestToQuestion(dto);

        User user = (User) userService
                .userDetailsService()
                .loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        question.setUser(user);
        Question newQuestion = questionRepository.save(question);
        return questionMapper.questionToResponse(newQuestion);
    }

    @Override
    public QuestionResponse edit(long id, QuestionRequest dto) {

        Question question = questionRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Question with this ID not found"));
        question.setTitle(dto.getTitle());
        question.setContent(dto.getContent());

        //TODO: Trigger here if has media changed must remove all cascading images related with post_id

        Question updatedQuestion = questionRepository.save(question);
        return questionMapper.questionToResponse(updatedQuestion);
    }

    @Override
    public void Delete(long id) throws IllegalAccessException {
        Question question = questionRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Failed, Question not found to deleted"));

        User user = (User) userService
                .userDetailsService()
                .loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        if (question.getUser().getId() != user.getId()) {
            throw new IllegalAccessException("You are not authorized to edit this solution");
        }

        questionRepository.delete(question);
    }
}
