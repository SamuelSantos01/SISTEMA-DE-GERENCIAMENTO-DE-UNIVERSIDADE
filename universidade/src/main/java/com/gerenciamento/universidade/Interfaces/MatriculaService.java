package com.gerenciamento.universidade.Interfaces;

import java.util.List;
import org.springframework.stereotype.Service;
import com.gerenciamento.universidade.DTOs.MatriculaResponseDTO;

@Service
// criando uma interface "MatriculaService" com o prototipo de 4 metodos que serao usados por uma classe
public interface MatriculaService {
    public void matricularAluno(Long idAluno, Long idTurma, String curso);
    public List<MatriculaResponseDTO> consultarTodasAsMatriculas();
    MatriculaResponseDTO consultarById(Long id);
    void deletarMatricula(Long id);
}