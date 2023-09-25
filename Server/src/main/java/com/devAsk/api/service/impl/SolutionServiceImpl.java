package com.devAsk.api.service.impl;

import com.devAsk.api.dto.request.SolutionRequest;
import com.devAsk.api.dto.response.SolutionDetailResponse;
import com.devAsk.api.entity.Question;
import com.devAsk.api.entity.Solution;
import com.devAsk.api.entity.User;
import com.devAsk.api.exception.EntityNotFoundException;
import com.devAsk.api.mapper.QuestionMapper;
import com.devAsk.api.mapper.SolutionMapper;
import com.devAsk.api.repository.QuestionRepository;
import com.devAsk.api.repository.SolutionRepository;
import com.devAsk.api.service.SolutionService;
import com.devAsk.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SolutionServiceImpl implements SolutionService {

    private final SolutionRepository solutionRepository;
    private final QuestionRepository questionRepository;
    private final SolutionMapper solutionMapper;
    private final QuestionMapper questionMapper;
    private final UserService userService;

    @Override
    public SolutionDetailResponse getDetail(long id) {
        Solution solution = solutionRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("That solution not found."));
        return solutionMapper.solutionToResponse(solution);
    }

    @Override
    public List<SolutionDetailResponse> getAllFromQuestion(long questionId) {
        return solutionRepository
                .findSolutionsByQuestionId(questionId)
                .stream()
                .map(solutionMapper::solutionToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SolutionDetailResponse create(SolutionRequest dto) {

        Question question = questionRepository
                .findById(dto.getQuestionId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Question with this ID not found to Submit a new Solution"));

        Solution solution = SolutionMapper.INSTANCE.requestToSolution(dto);

        User user = (User) userService
                .userDetailsService()
                .loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        solution.setUser(user);
        solution.setQuestion(question);

        Solution newSolution = solutionRepository.save(solution);
        return solutionMapper.solutionToResponse(newSolution);
    }

    @Override
    public SolutionDetailResponse edit(long id, SolutionRequest dto) throws IllegalAccessException {
        Solution solution = solutionRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Solution with this id not found."));

        User user = (User) userService
                .userDetailsService()
                .loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        if (solution.getUser().getId() != user.getId()) {
            throw new IllegalAccessException("You are not authorized to edit this solution");
        }

        solution.setTitle(dto.getTitle());
        solution.setContent(dto.getContent());

        return solutionMapper.solutionToResponse(solution);
    }

    @Override
    public void delete(long id) throws IllegalAccessException {
        Solution solution = solutionRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Solution with this id not found."));

        User user = (User) userService
                .userDetailsService()
                .loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        if (solution.getUser().getId() != user.getId()) {
            throw new IllegalAccessException("You are not authorized to edit this solution");
        }

        solutionRepository.delete(solution);
    }
}
