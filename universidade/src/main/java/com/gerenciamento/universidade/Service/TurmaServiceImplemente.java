package com.gerenciamento.universidade.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamento.universidade.Entidades.Professor;
import com.gerenciamento.universidade.Entidades.Turma;
import com.gerenciamento.universidade.Interfaces.TurmaService;
import com.gerenciamento.universidade.Repositorio.RepositorioProfessor;
import com.gerenciamento.universidade.Repositorio.RepositorioTurma;

@Service
public class TurmaServiceImplemente implements TurmaService{

    @Autowired
    private RepositorioProfessor repositorioProfessor;
    
    @Autowired
    private RepositorioTurma repositorioTurma;
    
    @Override
    public Turma cadastrarTurma(Long idProfessor, String curso) {
        if (idProfessor == null) {
            throw new IllegalArgumentException("ID do professor não pode ser nulo");
        }
    
        if (curso == null || curso.isEmpty()) {
            throw new IllegalArgumentException("O nome do curso não pode ser nulo ou vazio");
        }
    
        Professor professor = repositorioProfessor.findById(idProfessor)
                .orElseThrow(() -> new IllegalArgumentException("Professor não encontrado"));
    
        Turma turma = new Turma();
        turma.setProfessores(new ArrayList<>());
        turma.setCurso(curso);
        turma.getProfessores().add(professor);
    
        return repositorioTurma.save(turma);
    }

    @Override
    public void deletarturma(Long id) {
        if(id != null){
            repositorioTurma.deleteById(id);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public List<Turma> consultarTodasAsTurmas() {
        List<Turma> turmas = repositorioTurma.findAll();
        return turmas;
    }

    @Override
    public Turma consultarById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID da turma não pode ser nulo");
        }

        return repositorioTurma.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada com o ID: " + id));
    }
}
