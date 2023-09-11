package br.com.brq.votacao.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.brq.votacao.enums.VotoEnum;
import br.com.brq.votacao.model.VotosEntity;
import java.util.List;



@Repository
public interface VotoRepository extends MongoRepository<VotosEntity, String> {

    VotosEntity findByCpfAssociadoAndIdentificadorPauta(String cpfAssociado, String identificadorPauta);

    Integer countByIdentificadorPauta(String identificadorPauta);

    Integer countByIdentificadorPautaAndVoto(String identificadorPauta, VotoEnum voto);

    List<VotosEntity> findByIdentificadorPauta(String identificadorPauta);
    
}
