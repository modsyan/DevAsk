package com.devAsk.api.mapper;


import com.devAsk.api.entity.Question;
import com.devAsk.api.dto.request.CreateEditQuestionRequest;
import com.devAsk.api.dto.response.QuestionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    Question createEditPostRequestToPost(CreateEditQuestionRequest dto);

    QuestionResponse PostToCreateEditPostResponse(Question question);

    QuestionResponse PostToGetPostResponse(Question question);
}