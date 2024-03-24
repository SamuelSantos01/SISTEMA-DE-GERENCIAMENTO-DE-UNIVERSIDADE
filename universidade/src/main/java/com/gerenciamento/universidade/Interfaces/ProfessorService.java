package com.gerenciamento.universidade.Interfaces;

import java.util.List;
import org.springframework.stereotype.Service;
import com.gerenciamento.universidade.Entidades.Professor;

@Service
public interface ProfessorService {
  public void cadastrarProfessor(Professor professor);
  public void deletarProfessor(Long id);
  public void atualizarDados(Professor professor);
  public List<Professor> consultarTodosOsProfessores();
  public Professor consultarById(Long id);
}

