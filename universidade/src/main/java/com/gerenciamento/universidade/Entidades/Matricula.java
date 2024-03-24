package com.gerenciamento.universidade.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "MATRICULA")
@Table(name = "MATRICULAS")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long RM;

    @Column(name = "CURSO")
    public String Curso;

    @ManyToOne
    public Aluno aluno;
}
