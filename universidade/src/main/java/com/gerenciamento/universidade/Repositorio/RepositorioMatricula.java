package com.gerenciamento.universidade.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gerenciamento.universidade.Entidades.Matricula;

// Interface criada herdando todos os atributos e metodos da biblioteca "JpaRepository" - Heranca
public interface RepositorioMatricula extends JpaRepository<Matricula, Long>{
    
}