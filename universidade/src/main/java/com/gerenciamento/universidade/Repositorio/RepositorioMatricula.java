package com.gerenciamento.universidade.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gerenciamento.universidade.Entidades.Matricula;

public interface RepositorioMatricula extends JpaRepository<Matricula, Long>{
    
}