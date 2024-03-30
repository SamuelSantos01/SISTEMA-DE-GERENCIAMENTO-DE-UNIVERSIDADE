package com.gerenciamento.universidade.Entidades;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TURMA")
@Table(name = "TURMAS")

public class Turma {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long RT_ID;

    @Column(name = "CURSO")
    public String curso;

    @ManyToMany
    private List<Professor> professores;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    private List<Matricula> matricula;
}