package pl.gispartner.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class adviceController {

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleUserNotFoundException(UserNotFoundException userNotFoundException) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), userNotFoundException.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), resourceNotFoundException.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleUserAuthorityMissingException(UserAuthorityMissingException userAuthorityMissingException) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.UNAUTHORIZED.value(), userAuthorityMissingException.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
    }
}
