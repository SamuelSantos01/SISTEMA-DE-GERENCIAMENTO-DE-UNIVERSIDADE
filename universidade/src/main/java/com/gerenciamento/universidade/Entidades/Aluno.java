package com.gerenciamento.universidade.Entidades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ALUNO")
@Table(name = "ALUNOS")
public class Aluno extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RA_ID;

    @OneToMany(mappedBy = "aluno")
    private List<Matricula> matriculas;

    public Aluno(String nome, String sobreNome, String telefone, String email) {
        super(nome, sobreNome, telefone, email);
    }
}
