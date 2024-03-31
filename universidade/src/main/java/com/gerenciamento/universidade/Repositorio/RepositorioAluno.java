package com.gerenciamento.universidade.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gerenciamento.universidade.Entidades.Aluno;

@Repository
// Interface criada herdando todos os atributos e metodos da biblioteca "JpaRepository" - Heranca
public interface RepositorioAluno extends JpaRepository<Aluno, Long>{
    
}