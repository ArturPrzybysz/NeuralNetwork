package exceptions;

public class MismatchingVectorSizeException extends Exception {
        public MismatchingVectorSizeException() {
            super("Mismatching vectors sizes");
        }
    }