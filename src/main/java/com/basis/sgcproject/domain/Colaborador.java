package com.basis.sgcproject.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(of = "id")
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

    @OneToMany(mappedBy = "colaborador")
    private List<ColaboradorCompetencia> competencias;

}
