package com.basis.sgcproject.exception;

public class EntidadeEmUsoException extends RegraNegocioException {
    private static final long serialVersionUID = 1L;

    public EntidadeEmUsoException(String mensagem) {
        super(mensagem);
    }
}
