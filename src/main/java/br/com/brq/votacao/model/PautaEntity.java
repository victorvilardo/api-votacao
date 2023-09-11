package br.com.brq.votacao.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.brq.votacao.enums.ResultadoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Document(collection = "pautas")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PautaEntity {
	
	@Id
	private String id;
	private String titulo;
	private String descricao;
	private ResultadoEnum resultado;
	private String identificadorPauta;
	private Long totalVotos;
	private Long totalVotosSim;
	private Long totalVotosNao;
	
}
