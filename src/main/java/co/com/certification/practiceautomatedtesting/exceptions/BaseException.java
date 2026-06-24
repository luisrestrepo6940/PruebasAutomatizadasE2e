package co.com.certification.practiceautomatedtesting.exceptions;

import java.io.Serial;

public class BaseException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public BaseException(String message) {
        super(message);
    }
}