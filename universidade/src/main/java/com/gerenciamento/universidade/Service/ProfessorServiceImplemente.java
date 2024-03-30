package com.gerenciamento.universidade.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gerenciamento.universidade.DTOs.ProfessorResponseDTO;
import com.gerenciamento.universidade.DTOs.TurmaDTO;
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
    public List<ProfessorResponseDTO> consultarTodosOsProfessores() {
        List<Professor> professores = repositorioProfessor.findAll();
        return professores.stream()
                .map(professor -> new ProfessorResponseDTO(
                        professor.getNome(),
                        professor.getSobreNome(),
                        professor.getFormacao(),
                        professor.getTurmas().stream()
                                .map(turma -> new TurmaDTO(turma.getRT_ID(), turma.getCurso()))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProfessorResponseDTO> consultarById(Long id) {
        if (id != null) {
            Optional<Professor> optionalProfessor = repositorioProfessor.findById(id);
            return optionalProfessor.map(professor -> new ProfessorResponseDTO(
                    professor.getNome(),
                    professor.getSobreNome(),
                    professor.getFormacao(),
                    professor.getTurmas().stream()
                            .map(turma -> new TurmaDTO(turma.getRT_ID(), turma.getCurso()))
                            .collect(Collectors.toList())
            ));
        } else {
            throw new IllegalArgumentException("ID do professor não pode ser nulo.");
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