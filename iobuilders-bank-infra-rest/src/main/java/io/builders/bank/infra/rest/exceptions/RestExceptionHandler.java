package io.builders.bank.infra.rest.exceptions;

import static org.springframework.http.HttpStatus.*;

import io.builders.bank.application.exception.ApplicationException;
import io.builders.bank.infra.rest.api.model.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ApplicationException.class})
    protected ResponseEntity<Object> handleApplicationException(final RuntimeException ex, final WebRequest request) {

        final ApplicationException applicationException = (ApplicationException) ex;

        final var error = new ErrorDTO();
        error.message(applicationException.getMessage());
        error.code(String.valueOf(applicationException.getErrorCode()));

        switch (applicationException.getErrorCode()) {
            case NOT_FOUND:
                return this.handleExceptionInternal(ex, error, new HttpHeaders(), NOT_FOUND, request);
            case VALIDATION:
                return this.handleExceptionInternal(ex, error, new HttpHeaders(), BAD_REQUEST, request);
            default:
                return this.handleExceptionInternal(ex, error, new HttpHeaders(), INTERNAL_SERVER_ERROR, request);
        }
    }

}