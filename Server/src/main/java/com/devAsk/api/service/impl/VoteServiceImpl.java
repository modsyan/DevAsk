package com.devAsk.api.service.impl;

import com.devAsk.api.dto.response.QuestionResponse;
import com.devAsk.api.dto.response.SolutionResponse;
import com.devAsk.api.enums.VoteType;
import com.devAsk.api.service.VoteService;

public class VoteServiceImpl implements VoteService {
    @Override
    public QuestionResponse question(long questionId, VoteType vote) {
        return null;
    }

    @Override
    public SolutionResponse solution(long solutionId, VoteType vote) {
        return null;
    }
}
