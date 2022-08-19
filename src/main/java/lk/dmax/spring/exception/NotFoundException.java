package lk.dmax.spring.exception;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }
}
