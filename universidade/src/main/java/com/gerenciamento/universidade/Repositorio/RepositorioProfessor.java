package com.gerenciamento.universidade.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento.universidade.Entidades.Professor;

public interface RepositorioProfessor extends JpaRepository<Professor, Long>{
    
}
