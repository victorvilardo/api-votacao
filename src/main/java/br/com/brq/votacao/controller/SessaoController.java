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

import br.com.brq.votacao.dto.SessaoDTO;
import br.com.brq.votacao.persistence.PautaRepository;

import br.com.brq.votacao.service.interfaces.SessaoService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/sessoes")
public class SessaoController {

    Logger logger = LoggerFactory.getLogger(SessaoController.class);

	@Autowired
	private SessaoService sessaoService;

    @Autowired
    private PautaRepository pautaRepository;
	
    @ApiOperation(value="Cria uma sessão na pauta solicitada")
    @PostMapping
    public ResponseEntity<String> criarSessao(@RequestBody @Valid SessaoDTO sessaoDTO) {
        pautaRepository.findByIdentificadorPauta(sessaoDTO.getIdentificadorPauta());
        sessaoService.criarSessao(sessaoDTO);
        return new ResponseEntity<>("Sessão aberta com sucesso para a pauta: "  + sessaoDTO.getIdentificadorPauta(), HttpStatus.CREATED);
    }
}