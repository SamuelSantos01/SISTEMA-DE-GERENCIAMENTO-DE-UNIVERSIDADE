package com.gerenciamento.universidade.Interfaces;

import java.util.List;

import org.springframework.stereotype.Service;
import com.gerenciamento.universidade.Entidades.Matricula;
import com.gerenciamento.universidade.Entidades.Professor;
import com.gerenciamento.universidade.Entidades.Turma;


@Service
public interface TurmaService {
    public void cadastrarTurma(Professor professor);
    public void deletarturma(Long id);
    public List<Matricula> consultarTodasAsTurmas();
    public Turma consultarById(Long id);
}
