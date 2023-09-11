package br.com.brq.votacao.exception;

public class PautaNotFoundException extends RuntimeException {
    public PautaNotFoundException(String pautaId) {
        super("Pauta não encontrada ID: " + pautaId);
    }
}
