package br.com.brq.votacao.exception;

public class VotoException extends RuntimeException {
    public VotoException() {
        super("Este Associado ja votou!");
    }
}
