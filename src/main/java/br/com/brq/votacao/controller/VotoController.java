package br.com.brq.votacao.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brq.votacao.dto.VotosDTO;
import br.com.brq.votacao.service.interfaces.VotoService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/votos")
public class VotoController {

     Logger logger = LoggerFactory.getLogger(VotoController.class);

	@Autowired
	private VotoService votoService;
	
    @ApiOperation(value="Registra um voto na pauta solicitada")
    @PostMapping
    public ResponseEntity<String> registrarVoto(@RequestBody @Valid VotosDTO votoDTO) {
        
        votoService.registrarVoto(votoDTO);
        return new ResponseEntity<>("Voto computado com sucesso", HttpStatus.CREATED);
    }

}