package com.basis.sgcproject.exception.handler;

import lombok.Getter;

@Getter
public enum ProblemType {

    ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio"),
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
    ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
    DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "http://basis.com.br" + path;
        this.title = title;
    }
}
