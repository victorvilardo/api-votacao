package br.com.brq.votacao.model.Error;

import java.util.ArrayList;
import java.util.List;



import lombok.Data;

@Data
public class ValidateError {

    private int status;
    private String message;
    private List<FieldError> fieldErrors = new ArrayList<>();
    

    public ValidateError(int status, String message){
        this.status = status;
        this.message = message;
    } 

    public void addFieldError(String campo, String messagem) {
        FieldError fieldError = new FieldError(campo, messagem);
        fieldErrors.add(fieldError);
    }
}
