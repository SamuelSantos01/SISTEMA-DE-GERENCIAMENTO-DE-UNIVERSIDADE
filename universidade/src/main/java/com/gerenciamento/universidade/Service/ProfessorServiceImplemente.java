package com.gerenciamento.universidade.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamento.universidade.Entidades.Professor;
import com.gerenciamento.universidade.Interfaces.ProfessorService;
import com.gerenciamento.universidade.Repositorio.RepositorioProfessor;

@Service
public class ProfessorServiceImplemente implements ProfessorService {
    
    @Autowired
    private RepositorioProfessor repositorioProfessor;

    @Override
    public Professor cadastrarProfessor(Professor professor){
        if (professor != null) {
            return repositorioProfessor.save(professor);
        } else {
            throw new IllegalArgumentException("O objeto professor não pode ser nulo.");
        }
    }
    
    @Override
    public List<Professor> consultarTodosOsProfessores(){
        List<Professor> professores = repositorioProfessor.findAll();

        return professores;
    }

    @Override
    public Optional<Professor> consultarById(Long id){
        if (id != null) {
            return repositorioProfessor.findById(id);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void deletarProfessor(Long id){
        if(id != null){
            repositorioProfessor.deleteById(id);
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
