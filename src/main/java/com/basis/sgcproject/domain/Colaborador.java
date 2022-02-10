package com.basis.sgcproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "colaborador")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Colaborador implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_colaborador")
    @SequenceGenerator(name = "seq_colaborador", sequenceName = "seq_colaborador", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "foto")
    private byte[] foto;

    @ManyToOne
    @JoinColumn(name = "id_senioridade", referencedColumnName = "id" )
    private Senioridade senioridade;

    @Column(name = "data_nasc", nullable = false)
    private LocalDateTime dataNascimento;

    @Column(name = "data_admi", nullable = false)
    private LocalDateTime dataAdmissao;


}
