package com.devAsk.api.mapper;


import com.devAsk.api.dto.request.QuestionRequest;
import com.devAsk.api.dto.response.QuestionDetailResponse;
import com.devAsk.api.entity.Question;
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

    Question requestToQuestion(QuestionRequest dto);

    QuestionResponse questionToResponse(Question question);
    QuestionDetailResponse questionToResponseDetail (Question question);
}