package com.gerenciamento.universidade.Entidades;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "MATRICULA")
@Table(name = "MATRICULAS")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long RM_ID;

    @Column(name = "CURSO")
    public String Curso;

    @ManyToOne()
    @JoinColumn(name = "RA_ID", nullable = false)
    public Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "RT_ID", nullable = false)
    public Turma turma;
}
