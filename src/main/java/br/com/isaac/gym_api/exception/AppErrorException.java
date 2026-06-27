package br.com.isaac.gym_api.exception;

import lombok.Getter;

@Getter
public class AppErrorException extends RuntimeException {
    private final Integer statusCode;

    public AppErrorException(String message, Integer statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
