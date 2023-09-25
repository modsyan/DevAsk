package com.devAsk.api.service;

import com.devAsk.api.dto.request.SolutionRequest;
import com.devAsk.api.dto.response.SolutionDetailResponse;

import java.util.List;

public interface SolutionService {
    SolutionDetailResponse getDetail(long id);

    List<SolutionDetailResponse> getAllFromQuestion(long questionId);

    SolutionDetailResponse create(SolutionRequest dto);

    SolutionDetailResponse edit(long id, SolutionRequest dto) throws IllegalAccessException;

    void delete(long id) throws IllegalAccessException;
}
