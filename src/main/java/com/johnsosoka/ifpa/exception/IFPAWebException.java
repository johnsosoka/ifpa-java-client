package com.johnsosoka.ifpa.exception;

public class IFPAWebException extends IFPAException {

        public IFPAWebException(int statusCode) {
            super("IFPA API returned status code: " + statusCode);
        }

        public IFPAWebException(String message, Throwable cause) {
            super(message, cause);
        }

        public IFPAWebException(Throwable cause) {
            super(cause);
        }

        public IFPAWebException() {
            super();
        }
}
