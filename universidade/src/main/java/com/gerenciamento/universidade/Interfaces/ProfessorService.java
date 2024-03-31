package com.gerenciamento.universidade.Interfaces;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.gerenciamento.universidade.DTOs.ProfessorResponseDTO;
import com.gerenciamento.universidade.Entidades.Professor;

@Service
// criando uma interface "ProfessorService" com o prototipo de 4 metodos que serao usados por uma classe
public interface ProfessorService {
  public Professor cadastrarProfessor(Professor professor);
  public List<ProfessorResponseDTO> consultarTodosOsProfessores();
  public Optional<ProfessorResponseDTO> consultarById(Long id);
  public void deletarProfessor(Long id);
  //public void atualizarDados(Professor professor);
}