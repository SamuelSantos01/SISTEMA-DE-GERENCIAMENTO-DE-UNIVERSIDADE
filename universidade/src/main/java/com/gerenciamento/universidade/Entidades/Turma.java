package com.gerenciamento.universidade.Entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "TURMA")
@Table(name = "TURMAS")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long RT_ID;

    @Column(name = "CURSO")
    public String curso;

    @ManyToMany
    public List<Professor> professor;


    public Turma(Long rT_ID, String curso) {
        RT_ID = rT_ID;
        this.curso = curso;
    }

}
