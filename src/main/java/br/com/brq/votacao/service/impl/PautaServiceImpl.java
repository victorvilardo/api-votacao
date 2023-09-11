package br.com.brq.votacao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brq.votacao.dto.PautaDTO;
import br.com.brq.votacao.dto.ResultadoDTO;
import br.com.brq.votacao.enums.ResultadoEnum;
import br.com.brq.votacao.enums.VotoEnum;
import br.com.brq.votacao.mapper.PautaMapper;
import br.com.brq.votacao.model.PautaEntity;
import br.com.brq.votacao.model.VotosEntity;
import br.com.brq.votacao.persistence.PautaRepository;
import br.com.brq.votacao.persistence.VotoRepository;
import br.com.brq.votacao.service.interfaces.PautaService;



@Service
public class PautaServiceImpl implements PautaService {
	
	@Autowired
	private PautaRepository pautaRepository;

    @Autowired
	private VotoRepository votoRepository;

	@Override
	public String salvarPauta(PautaDTO pautaDTO) {
        PautaEntity pauta = pautaRepository.save(PautaMapper.INSTANCE.pautaDTOtoEntity(pautaDTO));
        return pauta.getIdentificadorPauta();
        
    }

    @Override
    public ResultadoDTO buscaResultado(String identificadorPauta) {
        PautaEntity pauta = pautaRepository.save(geraResultado(identificadorPauta));
     
        return PautaMapper.INSTANCE.pautaEntityToResultadoDTO(pauta);
    }

    private PautaEntity geraResultado (String identificadorPauta) {

        PautaEntity pauta = pautaRepository.findByIdentificadorPauta(identificadorPauta);
        List<VotosEntity> votos = votoRepository.findByIdentificadorPauta(identificadorPauta);
        return contabilizaVotos(pauta, votos);
        
    }

    private PautaEntity contabilizaVotos(PautaEntity pauta, List<VotosEntity> votos) {
        Long votosSim = votos.stream().filter(voto -> voto.getVoto().equals(VotoEnum.SIM)).count();
        
        pauta.setTotalVotos(Long.valueOf(votos.size()));
        pauta.setTotalVotosNao(Long.valueOf(votos.size()) - votosSim);
        pauta.setTotalVotosSim(votosSim);
        pauta.setResultado(pauta.getTotalVotosSim() > pauta.getTotalVotosNao() ? ResultadoEnum.ACEITO : pauta.getTotalVotosSim() < pauta.getTotalVotosNao() ? ResultadoEnum.NEGADO : ResultadoEnum.EMPATE);

        return pauta;
    }

    


}
