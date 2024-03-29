package com.gerenciamento.universidade.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gerenciamento.universidade.Entidades.Aluno;
import com.gerenciamento.universidade.Interfaces.AlunoService;
import com.gerenciamento.universidade.Repositorio.RepositorioAluno;


@Service
public class AlunoServiceImplemente implements AlunoService{

    @Autowired
    private RepositorioAluno repositorioAluno;

    @Override
    public Aluno cadastrarAluno(Aluno aluno){
        if (aluno != null) {
            return repositorioAluno.save(aluno);
        } else {
            throw new IllegalArgumentException("O objeto Aluno não pode ser nulo.");
        }
    }

    @Override
    public List<Aluno> consultarTodosOsAlunos(){
        List<Aluno> alunos = repositorioAluno.findAll();
        return alunos;
    }


    @Override
    public Optional<Aluno> consultarById(Long id){
        if (id != null) {
            return repositorioAluno.findById(id);
        } else {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public void deletarAluno(Long id){
        if(id != null){
            repositorioAluno.deleteById(id);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

}



