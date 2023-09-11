package br.com.brq.votacao.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document(collection = "sessaoVotacao")
public class SessaoEntity {
	
	@Id
	private String id;
	private String identificadorPauta;
	private LocalDateTime inicioSessao;
	private LocalDateTime terminoSessao;
	
}
