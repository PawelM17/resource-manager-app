package pl.gispartner.ResourceManagerApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class adviceController {

    @ExceptionHandler
    public ResponseEntity<ErrorObject> handleUserNotFoundException(UserNotFoundException userNotFoundException) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObject.setMessage(userNotFoundException.getMessage());
        errorObject.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorObject, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorObject> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObject.setMessage(resourceNotFoundException.getMessage());
        errorObject.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorObject, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorObject> handleUserAuthorityMissingException(UserAuthorityMissingException userAuthorityMissingException) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.UNAUTHORIZED.value());
        errorObject.setMessage(userAuthorityMissingException.getMessage());
        errorObject.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorObject, HttpStatus.UNAUTHORIZED);
    }
}
