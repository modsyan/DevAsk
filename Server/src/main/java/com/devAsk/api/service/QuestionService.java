package com.devAsk.api.service;

import com.devAsk.api.dto.request.CreateEditQuestionRequest;
import com.devAsk.api.dto.response.QuestionResponse;

import java.util.List;

public interface QuestionService {

    QuestionResponse GetDetails(long id);

    List<QuestionResponse> GetAll();

    QuestionResponse Create(CreateEditQuestionRequest dto);

    QuestionResponse Edit(long id, CreateEditQuestionRequest dto);

    void Delete(long id);
}
