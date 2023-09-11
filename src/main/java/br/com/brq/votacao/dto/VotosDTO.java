package br.com.brq.votacao.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "Votos")
public class VotosDTO {

    @NotBlank(message = "CPF do associado é obrigatório!")
    private String cpfAssociado;

    @NotBlank(message = "Identificador da pauta é obrigatório!")
    private String identificadorPauta;

    @NotBlank(message = "Voto é obrigatório!")
    @Pattern(regexp = "SIM|NAO",flags = Pattern.Flag.CASE_INSENSITIVE, message = "Voto só pode ser SIM ou NAO")
    private String voto;

}
