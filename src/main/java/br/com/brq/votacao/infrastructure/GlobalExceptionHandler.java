package br.com.brq.votacao.infrastructure;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import br.com.brq.votacao.exception.SessaoAtivaExcpetion;
import br.com.brq.votacao.exception.VotoException;
import br.com.brq.votacao.model.Error.GenericError;
import br.com.brq.votacao.model.Error.ValidateError;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class GlobalExceptionHandler{
   
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidateError methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }

    private ValidateError processFieldErrors(List<org.springframework.validation.FieldError> fieldErrors) {
        ValidateError error = new ValidateError(BAD_REQUEST.value(), "Erro de validação!");
        for (org.springframework.validation.FieldError fieldError: fieldErrors) {
            error.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return error;
    }

    @ResponseStatus(HttpStatus.TOO_EARLY)
    @ResponseBody
    @ExceptionHandler({SessaoAtivaExcpetion.class, VotoException.class} )
    public GenericError methodTooEarlyRequest(Exception ex) {  
        return new GenericError(HttpStatus.TOO_EARLY.value(), ex.getMessage());
    }

}
