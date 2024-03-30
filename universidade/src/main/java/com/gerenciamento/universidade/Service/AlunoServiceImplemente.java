package com.gerenciamento.universidade.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gerenciamento.universidade.DTOs.AlunoResponseDTO;
import com.gerenciamento.universidade.DTOs.MatriculaDTO;
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
    public List<AlunoResponseDTO> consultarTodosOsAlunos() {
        List<Aluno> alunos = repositorioAluno.findAll();
        return alunos.stream()
                .map(aluno -> new AlunoResponseDTO(aluno.getNome(), aluno.getSobreNome(), obterMatriculaDTOs(aluno)))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AlunoResponseDTO> consultarById(Long id) {
        if (id != null) {
            Optional<Aluno> optionalAluno = repositorioAluno.findById(id);
            return optionalAluno.map(aluno -> new AlunoResponseDTO(aluno.getNome(), aluno.getSobreNome(), obterMatriculaDTOs(aluno)));
        } else {
            throw new IllegalArgumentException("ID do aluno não pode ser nulo.");
        }
    }

    //método auxiliar para os métodos "consultarById e consultarTodosOsAlunos"
    private List<MatriculaDTO> obterMatriculaDTOs(Aluno aluno) {
        return aluno.getMatriculas().stream()
                .map(matricula -> new MatriculaDTO(matricula.getRM_ID(), matricula.getCurso())).collect(Collectors.toList());
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