package br.com.brq.votacao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.brq.votacao.dto.SessaoDTO;
import br.com.brq.votacao.model.SessaoEntity;


@Mapper 
public interface SessaoMapper {
 
    SessaoMapper INSTANCE = Mappers.getMapper( SessaoMapper.class ); 
    SessaoDTO pautaEntityToDTO(SessaoEntity pauta); 
}