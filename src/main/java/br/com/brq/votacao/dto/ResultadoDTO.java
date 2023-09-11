package br.com.brq.votacao.dto;

import br.com.brq.votacao.enums.ResultadoEnum;
import lombok.Data;

@Data
public class ResultadoDTO {

	private String titulo;
	private ResultadoEnum resultado;
	private Long totalVotos;
	private Long totalVotosSim;
	private Long totalVotosNao;
    
}
