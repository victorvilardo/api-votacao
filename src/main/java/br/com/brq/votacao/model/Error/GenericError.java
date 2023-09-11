package br.com.brq.votacao.model.Error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericError {

    private int codigo;
    private String mensagem;
    
}
