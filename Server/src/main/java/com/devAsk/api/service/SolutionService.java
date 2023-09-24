package com.devAsk.api.service;

import com.devAsk.api.dto.request.SolutionRequest;
import com.devAsk.api.dto.response.SolutionResponse;

import java.util.List;

public interface SolutionService {
    SolutionResponse getDetail(long id);

    List<SolutionResponse> getAllFromQuestion(long questionId);

    SolutionResponse create(SolutionRequest dto);

    SolutionResponse edit(long id, SolutionRequest dto) throws IllegalAccessException;

    void delete(long id) throws IllegalAccessException;
}
