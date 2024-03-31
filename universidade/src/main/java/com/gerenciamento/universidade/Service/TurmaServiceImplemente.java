package com.gerenciamento.universidade.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gerenciamento.universidade.DTOs.TurmaResponseDTO;
import com.gerenciamento.universidade.Entidades.Matricula;
import com.gerenciamento.universidade.Entidades.Professor;
import com.gerenciamento.universidade.Entidades.Turma;
import com.gerenciamento.universidade.Interfaces.TurmaService;
import com.gerenciamento.universidade.Repositorio.RepositorioProfessor;
import com.gerenciamento.universidade.Repositorio.RepositorioTurma;

@Service
// classe criada implementando a interface "TurmaService" - Poliformismo
public class TurmaServiceImplemente implements TurmaService{

    @Autowired
    // criando um objeto visivel somente para esta classe - Encapsulamento
    private RepositorioProfessor repositorioProfessor;
    
    @Autowired
    // criando um objeto visivel somente para esta classe - Encapsulamento
    private RepositorioTurma repositorioTurma;
    
    @Override
    // metodo utilizado para cadastrar uma nova turma
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
    // metodo utilizado para deletar uma turma especifica por "id"
    public void deletarturma(Long id) {
        if(id != null){
            repositorioTurma.deleteById(id);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    // metodo utilizado para consultar todas as turmas
    public List<TurmaResponseDTO> consultarTodasAsTurmas() {
        List<Turma> turmas = repositorioTurma.findAll();
        return turmas.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    // metodo utilizado para consultar uma turma especifica por "id"
    public TurmaResponseDTO consultarById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID da turma não pode ser nulo");
        }

        Turma turma = repositorioTurma.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada com o ID: " + id));
        
        return convertToDTO(turma);
    }

    // metodo utilizado para auxiliar os metodos "consultarById" e "consultarTodasAsTurmas"
    private TurmaResponseDTO convertToDTO(Turma turma) {
        List<Long> professorIds = turma.getProfessores().stream()
                .map(Professor::getRP_ID)
                .collect(Collectors.toList());
        List<Long> matriculaIds = turma.getMatricula().stream()
                .map(Matricula::getRM_ID)
                .collect(Collectors.toList());
        return new TurmaResponseDTO(turma.getRT_ID(), turma.getCurso(), professorIds, matriculaIds);
    }
}