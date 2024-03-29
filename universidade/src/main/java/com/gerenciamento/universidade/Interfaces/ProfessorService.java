package com.gerenciamento.universidade.Interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.gerenciamento.universidade.Entidades.Professor;

@Service
public interface ProfessorService {
  public Professor cadastrarProfessor(Professor professor);
  public List<Professor> consultarTodosOsProfessores();
  public Optional<Professor> consultarById(Long id);
  public void deletarProfessor(Long id);
  //public void atualizarDados(Professor professor);

}

