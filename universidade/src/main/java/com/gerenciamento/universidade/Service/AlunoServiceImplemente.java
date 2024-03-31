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
// classe criada implementado a interface "AlunoService" - Poliformismo
public class AlunoServiceImplemente implements AlunoService{

    @Autowired
    // criando um objeto visivel somente para esta classe - Encapsulamento
    private RepositorioAluno repositorioAluno;

    @Override
    // metodo utilizado para cadastrar um novo aluno
    public Aluno cadastrarAluno(Aluno aluno){
        if (aluno != null) {
            return repositorioAluno.save(aluno);
        } else {
            throw new IllegalArgumentException("O objeto Aluno não pode ser nulo.");
        }
    }

    @Override
    // metodo utilizado para consultar todos os alunos
    public List<AlunoResponseDTO> consultarTodosOsAlunos() {
        List<Aluno> alunos = repositorioAluno.findAll();
        return alunos.stream()
                .map(aluno -> new AlunoResponseDTO(aluno.getNome(), aluno.getSobreNome(), obterMatriculaDTOs(aluno)))
                .collect(Collectors.toList());
    }

    @Override
    // metodo utilizado para consultar um aluno por "id"
    public Optional<AlunoResponseDTO> consultarById(Long id) {
        if (id != null) {
            Optional<Aluno> optionalAluno = repositorioAluno.findById(id);
            return optionalAluno.map(aluno -> new AlunoResponseDTO(aluno.getNome(), aluno.getSobreNome(), obterMatriculaDTOs(aluno)));
        } else {
            throw new IllegalArgumentException("ID do aluno não pode ser nulo.");
        }
    }

    //método utilizado para auxiliar os métodos "consultarById" e "consultarTodosOsAlunos"
    private List<MatriculaDTO> obterMatriculaDTOs(Aluno aluno) {
        return aluno.getMatriculas().stream()
                .map(matricula -> new MatriculaDTO(matricula.getRM_ID(), matricula.getCurso())).collect(Collectors.toList());
    }

    @Override
    // metodo utilizado para deletar um aluno especifico por "id"
    public void deletarAluno(Long id){
        if(id != null){
            repositorioAluno.deleteById(id);
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}