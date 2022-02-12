package com.basis.sgcproject.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(of = "id")
@Entity
@Getter
@Setter
@Table( name = "competencia")
@NoArgsConstructor
public class Competencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_competencia")
    @SequenceGenerator(name = "seq_competencia", sequenceName = "seq_competencia", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;
}
