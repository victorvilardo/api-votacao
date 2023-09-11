package br.com.brq.votacao.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.brq.votacao.model.PautaEntity;


@Repository
public interface PautaRepository extends MongoRepository<PautaEntity, String>{

    PautaEntity findByIdentificadorPauta(String identificadorPauta);

}
