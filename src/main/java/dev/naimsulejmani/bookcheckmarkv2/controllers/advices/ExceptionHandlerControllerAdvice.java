package dev.naimsulejmani.bookcheckmarkv2.controllers.advices;

import dev.naimsulejmani.bookcheckmarkv2.dtos.ErrorResponseDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.net.BindException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {


//    @ExceptionHandler(EntityNotFoundException.class)
//    public ResponseEntity<ErrorResponseDto> handleEntityNotFoundException(HttpServletRequest request,
//                                                                          EntityNotFoundException e) {
//        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
//        errorResponseDto.setStatus(HttpStatus.NOT_FOUND.value());
//        errorResponseDto.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
//        errorResponseDto.setMessage(e.getMessage());
//        errorResponseDto.setPath(request.getRequestURI());
//        errorResponseDto.setMethod(request.getMethod());
//
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDto);
//    }
//
//
//    @ExceptionHandler({IllegalArgumentException.class, IndexOutOfBoundsException.class,
//            ObjectOptimisticLockingFailureException.class})
//    public ResponseEntity<ErrorResponseDto> handleIllegalArgumentException(HttpServletRequest request,
//                                                                           RuntimeException e) {
//        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
//        errorResponseDto.setStatus(HttpStatus.BAD_REQUEST.value());
//        errorResponseDto.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
//        errorResponseDto.setMessage(e.getMessage());
//        errorResponseDto.setPath(request.getRequestURI());
//        errorResponseDto.setMethod(request.getRequestURI());
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDto);
//    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(HttpServletRequest request,
                                                            Exception e) {

        HttpStatus defaultStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(e.getMessage());
        errorResponseDto.setPath(request.getRequestURI());
        errorResponseDto.setMethod(request.getMethod());

        if (e instanceof BindException || e instanceof MethodArgumentNotValidException || e instanceof IllegalArgumentException
        || e instanceof HandlerMethodValidationException) {
            defaultStatus = HttpStatus.BAD_REQUEST;
        } else if (e instanceof EntityNotFoundException) {
            defaultStatus = HttpStatus.NOT_FOUND;
        }

        errorResponseDto.setStatus(defaultStatus.value());
        errorResponseDto.setError(defaultStatus.getReasonPhrase());

        return ResponseEntity.status(defaultStatus).body(errorResponseDto);
    }

}
