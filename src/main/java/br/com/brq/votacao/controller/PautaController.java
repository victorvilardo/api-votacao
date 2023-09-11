package br.com.brq.votacao.controller;

import javax.validation.Valid;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brq.votacao.dto.PautaDTO;
import br.com.brq.votacao.dto.ResultadoDTO;
import br.com.brq.votacao.service.interfaces.PautaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/pautas")
@Api(value="API REST Votação")
public class PautaController {

    Logger logger = LoggerFactory.getLogger(PautaController.class);
    
    @Autowired
    private PautaService pautaService;
    
    @ApiOperation(value="Realiza o cadastro de uma pauta na API")
    @PostMapping
    public ResponseEntity<String> cadastrarPauta(@RequestBody @Valid PautaDTO pautaDTO) {
        String identificadorPauta = pautaService.salvarPauta(pautaDTO);
        return new ResponseEntity<>("Pauta cadastrada com sucesso. ID: " + identificadorPauta, HttpStatus.CREATED);
    }

    @ApiOperation(value="Contabiliza os votos registrados na pauta")
    @GetMapping("{id}/resultado")
    public ResponseEntity<ResultadoDTO> contabilizarResultadoPalta(@PathVariable String id){

        return ResponseEntity.ok(pautaService.buscaResultado(id));
    }
    
    
}
