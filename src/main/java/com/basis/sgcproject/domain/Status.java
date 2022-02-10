package com.basis.sgcproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "status" )
@Getter
@Setter
public class Status implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "descricao", nullable = false)
    private String descricao;
}