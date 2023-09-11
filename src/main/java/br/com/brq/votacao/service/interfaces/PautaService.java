package br.com.brq.votacao.service.interfaces;

import br.com.brq.votacao.dto.PautaDTO;
import br.com.brq.votacao.dto.ResultadoDTO;




public interface PautaService {
	
	 String salvarPauta(PautaDTO pautaDTO);

	 ResultadoDTO buscaResultado(String identificadorPauta);

}
