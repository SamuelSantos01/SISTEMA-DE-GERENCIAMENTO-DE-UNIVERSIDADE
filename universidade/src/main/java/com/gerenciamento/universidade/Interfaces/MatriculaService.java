package com.gerenciamento.universidade.Interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gerenciamento.universidade.Entidades.Matricula;

@Service
public interface MatriculaService {
    public void matricularAluno(Long idAluno, Long idTurma, String curso);

    List<Matricula> consultarTodasAsMatriculas();

    Matricula consultarById(Long id);

    void deletarMatricula(Long id);
}
