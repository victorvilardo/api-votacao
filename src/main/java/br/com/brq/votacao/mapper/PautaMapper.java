package br.com.brq.votacao.mapper;

import java.time.Instant;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.brq.votacao.dto.PautaDTO;
import br.com.brq.votacao.dto.ResultadoDTO;
import br.com.brq.votacao.model.PautaEntity;

@Mapper
public interface PautaMapper{

    PautaMapper  INSTANCE = Mappers.getMapper( PautaMapper.class ); 
    PautaDTO pautaEntityToDTO(PautaEntity pauta); 
    PautaEntity pautaDTOtoEntity(PautaDTO pautaDTO);
    ResultadoDTO pautaEntityToResultadoDTO(PautaEntity pauta); 


    @AfterMapping
    default void pautaEntityAfterMapper( PautaDTO pautaDTO , @MappingTarget PautaEntity pauta) {
        Long hash = Instant.now().getEpochSecond();
        pauta.setIdentificadorPauta(pautaDTO.getTitulo().replaceAll(" ","") + hash);
 }

}