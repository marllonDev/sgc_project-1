package com.basis.sgcproject.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorSenioridadeListDTO implements Serializable {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senioridadeNome;
}
