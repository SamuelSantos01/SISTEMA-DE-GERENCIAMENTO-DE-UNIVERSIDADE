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
@Entity(name = "PROFESSOR")
@Table(name = "PROFESSORES")
public class Professor extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RP_ID;

    @Column(name = "FORMAÇÃO")
    private String formacao;

    @ManyToMany(mappedBy = "professor")
    private List<Turma> turmas;

    public Professor(String nome, String sobreNome, String telefone, String email) {
        super(nome, sobreNome, telefone, email);
    }

}
