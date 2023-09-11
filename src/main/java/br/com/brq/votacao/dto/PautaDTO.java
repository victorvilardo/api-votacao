package br.com.brq.votacao.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public final class PautaDTO {
	
	@NotBlank(message = "Título é obrigatório!")
	private String titulo;
	
	@NotBlank(message = "Descrição é obrigatório!")
	private String descricao;

}
