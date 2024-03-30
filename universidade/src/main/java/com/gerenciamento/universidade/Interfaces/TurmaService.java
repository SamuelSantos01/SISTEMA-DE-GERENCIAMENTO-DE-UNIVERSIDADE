package com.gerenciamento.universidade.Interfaces;

import java.util.List;
import org.springframework.stereotype.Service;
import com.gerenciamento.universidade.DTOs.TurmaResponseDTO;
import com.gerenciamento.universidade.Entidades.Turma;

@Service
public interface TurmaService {
    public Turma cadastrarTurma(Long idProfessor, String curso);
    public void deletarturma(Long id);
    public List<TurmaResponseDTO> consultarTodasAsTurmas();
    public TurmaResponseDTO consultarById(Long id);
}