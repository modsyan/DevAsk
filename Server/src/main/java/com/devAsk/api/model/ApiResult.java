package com.devAsk.api.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import javax.xml.transform.Result;
import java.io.Serializable;

@Data
@Builder
public class ApiResult implements Serializable {

    private Boolean success;
    private String message;
    private Object data;

    public static ResponseEntity<ApiResult> Result(boolean success, String message, Object data, HttpStatus statusCode) {
        return new ResponseEntity<>(ApiResult.builder().message(message).data(data).success(true).build(), statusCode);
    }

    public static ResponseEntity<ApiResult> Ok(String message, Object data) {
        return ApiResult.Result(true, message, data, HttpStatus.OK);
    }

    public static ResponseEntity<ApiResult> Ok(String message) {
        return ApiResult.Ok(message, null);
    }

    public static ResponseEntity<ApiResult> Ok() {
        return ApiResult.Ok(null, null);
    }

    public static ResponseEntity<ApiResult> Created(String message, Object data) {
        return ApiResult.Result(true, message, data, HttpStatus.CREATED);
    }

    public static ResponseEntity<ApiResult> Created(String message) {
        return ApiResult.Created(message, null);
    }

    public static ResponseEntity<ApiResult> Created() {
        return ApiResult.Created(null);
    }

    public static ResponseEntity<ApiResult> Failed(String message, Object data, HttpStatus statusCode) {
        return ApiResult.Result(false, message, data, statusCode);
    }

    public static ResponseEntity<ApiResult> BadRequest(String message, Object data) {
        return ApiResult.Failed(message, data, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<ApiResult> BadRequest(String message) {
        return ApiResult.BadRequest(message, null);
    }

    public static ResponseEntity<ApiResult> NotFound(String message, Object data) {
        return ApiResult.Failed(message, data, HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<ApiResult> NotFound(String message) {
        return ApiResult.NotFound(message, null);
    }

    public static ResponseEntity<ApiResult> UnAuthorized(String message, Object data) {
        return ApiResult.Failed(message, data, HttpStatus.UNAUTHORIZED);
    }

    public static ResponseEntity<ApiResult> UnAuthorized(String message) {
        return ApiResult.UnAuthorized(message, null);
    }

}
