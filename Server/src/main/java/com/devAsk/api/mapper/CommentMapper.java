package com.devAsk.api.mapper;

import com.devAsk.api.dto.request.CommentRequest;
import com.devAsk.api.dto.response.CommentResponse;
import com.devAsk.api.entity.Comment;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;


@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface CommentMapper {
    SolutionMapper INSTANCE = Mappers.getMapper(SolutionMapper.class);
    Comment requestToSolution(CommentRequest dto);
    CommentResponse solutionToResponse(Comment Comment);
}
