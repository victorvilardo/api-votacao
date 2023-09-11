package br.com.brq.votacao.exception;

public class SessaoAtivaExcpetion extends RuntimeException {
     public SessaoAtivaExcpetion() {
        super("Não é possivel criar uma sessão!");
    }
}

