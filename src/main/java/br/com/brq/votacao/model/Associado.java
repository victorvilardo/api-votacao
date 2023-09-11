package br.com.brq.votacao.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "associados")
public class Associado {
	
	@Id
	private String id;
	private String nome;
	private String associado_cpf;

}
