package lk.dmax.spring.exception;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public class ValidateException extends RuntimeException {
    public ValidateException(String message) {
        super(message);
    }
}
