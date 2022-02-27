package com.basis.sgcproject.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorDTO implements Serializable {


    private Integer id;

    @NotEmpty
    @Size(min = 2, message = "nome de usuário deve ter pelo menos 2 caracteres")
    private String nome;

    @NotEmpty
    @Size(min = 2, message = "nome de usuário deve ter pelo menos 2 caracteres")
    private String sobrenome;

    @NotNull
    @CPF
    @Size(min = 11, max = 11)
    private String cpf;

    @NotNull
    @Email
    private String email;

    private String foto;

    @NotEmpty
    private Integer senioridadeID;

    private List<ColaboradorCompetenciaListNivelDTO> colaboradorCompetencias;

    @NotEmpty
    @Past(message = "A data não pode ser maior que a data atual.")
    private LocalDateTime dataNascimento;

    private LocalDateTime dataAdmissao;
}
