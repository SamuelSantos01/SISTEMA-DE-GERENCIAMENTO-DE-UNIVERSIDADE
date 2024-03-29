package com.gerenciamento.universidade.Interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.gerenciamento.universidade.Entidades.Aluno;

@Service
public interface AlunoService {
    public Aluno cadastrarAluno(Aluno aluno);
    public List<Aluno> consultarTodosOsAlunos();
    public Optional<Aluno> consultarById(Long id);
    public void deletarAluno(Long id);
    //public void atualizarDados(Aluno aluno);
    
}
