package br.com.brq.votacao.service.interfaces;


import br.com.brq.votacao.dto.SessaoDTO;

public interface SessaoService {

    public void criarSessao(SessaoDTO sessaoDTO);

    public boolean existeSessaoAtivaPorPauta(String identificadorPauta);
    
}
