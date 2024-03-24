package com.gerenciamento.universidade.Interfaces;

import java.util.List;
import org.springframework.stereotype.Service;
import com.gerenciamento.universidade.Entidades.Aluno;
import com.gerenciamento.universidade.Entidades.Matricula;
import com.gerenciamento.universidade.Entidades.Turma;

@Service
public interface MatriculaService {
    public void matricularAluno(Aluno aluno, Turma turma);
    public void deletarMatricula(Long id);
    public List<Matricula> consultarTodasAsMatriculas();
    public Matricula consultarById(Long id);
}
