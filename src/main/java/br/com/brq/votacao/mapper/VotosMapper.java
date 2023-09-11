package br.com.brq.votacao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.brq.votacao.dto.VotosDTO;
import br.com.brq.votacao.model.VotosEntity;

@Mapper 
public interface VotosMapper {
 
    VotosMapper INSTANCE = Mappers.getMapper( VotosMapper.class ); 
    VotosDTO votosEntityToDTO(VotosEntity voto); 
}