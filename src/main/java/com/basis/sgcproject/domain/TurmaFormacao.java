package com.basis.sgcproject.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Entity
@Table(name = "turma_formacao")
public class TurmaFormacao implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_id_turma_formacao" , sequenceName = "seq_id_turma_formacao", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_turma_formacao")
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotBlank
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @NotNull
    @Column(name = "data_inicio", nullable = false)
    private LocalDateTime dataInicio;

    @NotNull
    @Column(name = "data_termino", nullable = false)
    private LocalDateTime dataTermino;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_status", nullable = false)
    private Status status;

    @NotNull
    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TurmaCompetenciaColaborador> competenciasColaboradores = new HashSet<>();
}
