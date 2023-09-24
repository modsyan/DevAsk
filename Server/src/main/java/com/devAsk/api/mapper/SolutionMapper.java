package com.devAsk.api.mapper;

import com.devAsk.api.dto.request.SolutionRequest;
import com.devAsk.api.dto.response.SolutionResponse;
import com.devAsk.api.entity.Solution;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface SolutionMapper {
    SolutionMapper INSTANCE = Mappers.getMapper(SolutionMapper.class);
    Solution requestToSolution(SolutionRequest dto);
    SolutionResponse solutionToResponse(Solution solution);
}