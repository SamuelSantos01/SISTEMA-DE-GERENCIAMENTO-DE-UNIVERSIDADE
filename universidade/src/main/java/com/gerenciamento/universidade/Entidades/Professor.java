package com.gerenciamento.universidade.Entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PROFESSOR")
@Table(name = "PROFESSORES")
public class Professor extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RP_ID;

    @Column(name = "FORMAÇÃO")
    private String formacao;

    @ManyToMany(mappedBy = "professores")
    private List<Turma> turmas;

}
