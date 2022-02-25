package com.basis.sgcproject.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class CategoriaDTO implements Serializable {
    @NotNull
    private Integer id;
    @NotNull
    private String nome;
}
