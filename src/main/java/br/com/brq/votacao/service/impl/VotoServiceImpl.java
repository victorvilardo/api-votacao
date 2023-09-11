package br.com.brq.votacao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brq.votacao.dto.VotosDTO;
import br.com.brq.votacao.enums.VotoEnum;
import br.com.brq.votacao.exception.SessaoAtivaExcpetion;
import br.com.brq.votacao.exception.VotoException;
import br.com.brq.votacao.model.VotosEntity;
import br.com.brq.votacao.persistence.VotoRepository;
import br.com.brq.votacao.service.interfaces.SessaoService;
import br.com.brq.votacao.service.interfaces.VotoService;



@Service
public class VotoServiceImpl implements VotoService {
	
	@Autowired
	private VotoRepository votoRepository;

	@Autowired
	private SessaoService sessaoService;

	@Override
	public void registrarVoto(VotosDTO votosDTO) {

		if (!sessaoService.existeSessaoAtivaPorPauta(votosDTO.getIdentificadorPauta())){
			throw new SessaoAtivaExcpetion();
		}

		if (votoRepository.findByCpfAssociadoAndIdentificadorPauta(votosDTO.getCpfAssociado(), votosDTO.getIdentificadorPauta()) != null ){
			throw new VotoException();
		}

		VotosEntity voto = new VotosEntity();
		voto.setCpfAssociado(votosDTO.getCpfAssociado());
		voto.setVoto(VotoEnum.valueOf(votosDTO.getVoto()));
		voto.setIdentificadorPauta(votosDTO.getIdentificadorPauta());
		votoRepository.save(voto);	
	}

}
