package com.gerenciamento.universidade.Interfaces;

import java.util.List;
import org.springframework.stereotype.Service;
import com.gerenciamento.universidade.Entidades.Aluno;

@Service
public interface AlunoService {
    public void cadastrarAluno(Aluno aluno);
    public void deletarAluno(Long id);
    public void atualizarDados(Aluno aluno);
    public List<Aluno> consultarTodosOsAlunos();
    public Aluno consultarById(Long id);
}
