package br.com.brq.votacao.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.brq.votacao.enums.VotoEnum;
import lombok.Data;

@Data
@Document(collection = "Votos")
public class VotosEntity {

    @Id
    private String id;
    private String cpfAssociado;
    private String identificadorPauta;
    private String identificaorSessao; 
    private VotoEnum voto; 
}
