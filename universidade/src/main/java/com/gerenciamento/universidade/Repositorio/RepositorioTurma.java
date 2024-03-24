package com.gerenciamento.universidade.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento.universidade.Entidades.Turma;

public interface RepositorioTurma extends JpaRepository<Turma, Long> {
    
}
