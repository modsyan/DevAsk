package com.devAsk.api.mapper;


import com.devAsk.api.entity.Question;
import com.devAsk.api.dto.request.CreateEditQuestionRequest;
import com.devAsk.api.dto.response.QuestionResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    Question createEditPostRequestToPost(CreateEditQuestionRequest dto);

    QuestionResponse questionToCreateEditQuestionResponse(Question question);

    QuestionResponse questionToQuestionResponse(Question question);
}