package com.devAsk.api.model.wrapper;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WithToken<T> {

    private T _data;
    private String _token;

    public WithToken(T data, String token) {
        _data = data;
        _token = token;
    }

}
