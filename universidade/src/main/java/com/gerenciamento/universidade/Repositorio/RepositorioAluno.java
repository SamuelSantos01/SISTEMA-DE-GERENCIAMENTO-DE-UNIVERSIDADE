package com.gerenciamento.universidade.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciamento.universidade.Entidades.Aluno;

@Repository
public interface RepositorioAluno extends JpaRepository<Aluno, Long>{
    
}
