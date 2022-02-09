package com.basis.sgcproject.exception.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio"),
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "http://basis.com.br" + path;
        this.title = title;
    }
}
