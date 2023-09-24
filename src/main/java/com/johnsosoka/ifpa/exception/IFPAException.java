package com.johnsosoka.ifpa.exception;

public class IFPAException extends Exception {

    public IFPAException(String message) {
        super(message);
    }

    public IFPAException(String message, Throwable cause) {
        super(message, cause);
    }

    public IFPAException(Throwable cause) {
        super(cause);
    }

    public IFPAException() {
        super();
    }
}
