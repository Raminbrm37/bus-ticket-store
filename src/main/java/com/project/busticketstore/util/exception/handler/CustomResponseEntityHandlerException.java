package com.project.busticketstore.util.exception.handler;

import com.project.busticketstore.util.exception.CompanyAlreadyException;
import com.project.busticketstore.util.exception.CompanyNotFoundException;
import com.project.busticketstore.util.exception.UserAlreadyExistException;
import com.project.busticketstore.util.exception.UserNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@ControllerAdvice
@RestController
public class CustomResponseEntityHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception e, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public final ResponseEntity<Object> userAlreadyExist(UserAlreadyExistException e, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> userNotFound(UserNotFoundException e, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CompanyNotFoundException.class)
    public final ResponseEntity<Object> userNotFound(CompanyNotFoundException e, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
  @ExceptionHandler(CompanyAlreadyException.class)
    public final ResponseEntity<Object> userNotFound(CompanyAlreadyException e, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ex.getBindingResult().getAllErrors().forEach(DefaultMessageSourceResolvable::getDefaultMessage);

        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(), "validation failed",getMessage(ex));
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    private String getMessage(MethodArgumentNotValidException ex) {
        List<String>  messages=new ArrayList<>();
        for(ObjectError objectError: ex.getBindingResult().getAllErrors()){
            messages.add( objectError.getDefaultMessage());
        }
        return messages.toString();
    }
}
