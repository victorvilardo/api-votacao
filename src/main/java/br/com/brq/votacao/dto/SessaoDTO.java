package br.com.brq.votacao.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;


@Data
public class SessaoDTO {

    @NotBlank(message = "Identificador da pauta é obrigatório!")
	private String identificadorPauta;

	private String terminoSessao;

}
