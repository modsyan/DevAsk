package com.devAsk.api.service;

import com.devAsk.api.dto.request.CreateEditQuestionRequest;
import com.devAsk.api.dto.response.QuestionResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionService {

    QuestionResponse GetDetails(long id);


    List<QuestionResponse> GetAll(Pageable pageable);

    QuestionResponse Create(CreateEditQuestionRequest dto);

    QuestionResponse Edit(long id, CreateEditQuestionRequest dto);

    void Delete(long id);
}
