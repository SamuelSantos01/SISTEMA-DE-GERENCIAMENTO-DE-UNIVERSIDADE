package com.gerenciamento.universidade.Interfaces;

import java.util.List;

import org.springframework.stereotype.Service;
import com.gerenciamento.universidade.Entidades.Turma;


@Service
public interface TurmaService {
    public Turma cadastrarTurma(Long idProfessor, String curso);
    public void deletarturma(Long id);
    public List<Turma> consultarTodasAsTurmas();
    public Turma consultarById(Long id);
}
