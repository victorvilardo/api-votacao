package br.com.brq.votacao.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brq.votacao.dto.SessaoDTO;
import br.com.brq.votacao.exception.SessaoAtivaExcpetion;
import br.com.brq.votacao.model.SessaoEntity;
import br.com.brq.votacao.persistence.SessaoRepository;
import br.com.brq.votacao.service.interfaces.SessaoService;

@Service
public class SessaoServiceImpl implements SessaoService  {

    @Autowired
    private SessaoRepository sessaoRepository;

    @Override
    public void criarSessao(SessaoDTO sessaoDTO) {
      
     
        if (existeSessaoAtivaPorPauta(sessaoDTO.getIdentificadorPauta())){
            throw new SessaoAtivaExcpetion();
        }

       
        SessaoEntity sessao = new SessaoEntity();
        LocalDateTime dateTimeAtual = LocalDateTime.now();

        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");    
        LocalDateTime dateTimeTermino = LocalDateTime.parse(sessaoDTO.getTerminoSessao(), formatter);



        if (sessaoDTO.getTerminoSessao() == null){
            dateTimeTermino = dateTimeAtual.plusMinutes(1);
        }
        sessao.setInicioSessao(dateTimeAtual);
        sessao.setTerminoSessao(dateTimeTermino);
        sessao.setIdentificadorPauta(sessaoDTO.getIdentificadorPauta());
        sessaoRepository.save(sessao);
    }

    @Override
    public boolean existeSessaoAtivaPorPauta(String identificadorPauta) {
        LocalDateTime tempoVoto = LocalDateTime.now();

        SessaoEntity sessao = sessaoRepository.findByIdentificadorPautaAndInicioSessaoLessThanAndTerminoSessaoGreaterThan(identificadorPauta, tempoVoto, tempoVoto);

        return sessao != null ? true : false;

    }
    
}
