package com.devAsk.api.service;

import com.devAsk.api.dto.request.QuestionRequest;
import com.devAsk.api.dto.response.QuestionDetailResponse;
import com.devAsk.api.dto.response.QuestionResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionService {

    QuestionDetailResponse getDetails(long id);

    List<QuestionResponse> getAll(Pageable pageable);

    QuestionResponse create(QuestionRequest dto);

    QuestionResponse edit(long id, QuestionRequest dto);

    void Delete(long id) throws IllegalAccessException;
}
