package com.devAsk.api.service;

import com.devAsk.api.dto.response.QuestionResponse;
import com.devAsk.api.dto.response.SolutionResponse;
import com.devAsk.api.enums.VoteType;
import org.springframework.stereotype.Service;

@Service
public interface VoteService {
    QuestionResponse question(long questionId, VoteType vote);

    SolutionResponse solution(long solutionId, VoteType vote);
}
