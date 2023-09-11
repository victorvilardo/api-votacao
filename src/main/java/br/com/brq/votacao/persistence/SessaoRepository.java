package br.com.brq.votacao.persistence;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.brq.votacao.model.SessaoEntity;


@Repository
public interface SessaoRepository extends MongoRepository<SessaoEntity, String> {

     SessaoEntity findByIdentificadorPautaAndInicioSessaoLessThanAndTerminoSessaoGreaterThan(String identificadorPauta, LocalDateTime tempoVoto, LocalDateTime tempoVoto2);
}
