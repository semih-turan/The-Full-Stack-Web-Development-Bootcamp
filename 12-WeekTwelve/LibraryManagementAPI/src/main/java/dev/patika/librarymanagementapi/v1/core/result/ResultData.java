package dev.patika.librarymanagementapi.v1.core.result;

import lombok.Getter;

@Getter
public class ResultData <T> extends Result {
    private T data;

    public ResultData(boolean status, String message, String httpCode, T data) {
        super(status, message, httpCode);
        this.data = data;
    }
}
