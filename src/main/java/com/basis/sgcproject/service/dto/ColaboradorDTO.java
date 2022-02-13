package com.basis.sgcproject.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorDTO implements Serializable {


    private Integer id;

    private String nome;

    private String sobrenome;

    private String cpf;

    private String email;

    private byte[] foto;

    private Integer senioridadeID;

    private Integer competenciaID;

    private LocalDateTime dataNascimento;

    private LocalDateTime dataAdmissao;
}
