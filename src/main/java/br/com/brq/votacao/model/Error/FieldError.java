package br.com.brq.votacao.model.Error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldError {
    
    private String campo;
    private String messagem;
    
}
