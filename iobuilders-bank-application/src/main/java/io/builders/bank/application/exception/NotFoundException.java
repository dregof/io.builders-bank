package io.builders.bank.application.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotFoundException extends Exception {

    private Error errorCode;

    public NotFoundException(final Error error, final String message) {
        super(message);
        this.errorCode = error;
    }

    public NotFoundException(final Error error, final String message, final Throwable cause) {
        super(message, cause);
        this.errorCode = error;
    }

}