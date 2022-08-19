package lk.dmax.spring.advisor;

import lk.dmax.spring.exception.NotFoundException;
import lk.dmax.spring.exception.ValidateException;
import lk.dmax.spring.util.StandradResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class AppWiseExceptionHeadle {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
       return new ResponseEntity(new StandradResponse("500", "Error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException e) {
        return new ResponseEntity(new StandradResponse("404", "Error", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidateException.class)
    public ResponseEntity handleValidationException(ValidateException e) {
        return new ResponseEntity(new StandradResponse("400", "Error", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
