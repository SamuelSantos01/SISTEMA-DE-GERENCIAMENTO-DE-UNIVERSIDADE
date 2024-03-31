package com.gerenciamento.universidade.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gerenciamento.universidade.DTOs.MatriculaResponseDTO;
import com.gerenciamento.universidade.Entidades.Aluno;
import com.gerenciamento.universidade.Entidades.Matricula;
import com.gerenciamento.universidade.Entidades.Turma;
import com.gerenciamento.universidade.Interfaces.MatriculaService;
import com.gerenciamento.universidade.Repositorio.RepositorioAluno;
import com.gerenciamento.universidade.Repositorio.RepositorioMatricula;
import com.gerenciamento.universidade.Repositorio.RepositorioTurma;

@Service
// classe criada implementando a interface "MatriculaService" - Poliformismo
public class MatriculaServiceImplemente implements MatriculaService {

    @Autowired
    // criando um objeto visivel somente para esta classe - Encapsulamento
    private RepositorioAluno repositorioAluno;

    @Autowired
    // criando um objeto visivel somente para esta classe - Encapsulamento
    private RepositorioTurma repositorioTurma;

    @Autowired
    // criando um objeto visivel somente para esta classe - Encapsulamento
    private RepositorioMatricula repositorioMatricula;

    @Override
    // metodo utilizado para realizar a matricula de alunos
    public void matricularAluno(Long idAluno, Long idTurma, String curso) {
        if (idAluno == null) {
            throw new IllegalArgumentException("ID do aluno não pode ser nulo");
        }

        if (idTurma == null) {
            throw new IllegalArgumentException("ID da turma não pode ser nulo");
        }

        Aluno aluno = repositorioAluno.findById(idAluno)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        Turma turma = repositorioTurma.findById(idTurma)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));

        Matricula matricula = new Matricula();
        matricula.setCurso(curso);
        matricula.setAluno(aluno);
        matricula.setTurma(turma);

        aluno.getMatriculas().add(matricula);
        turma.getMatricula().add(matricula);

        repositorioAluno.save(aluno);
        repositorioTurma.save(turma);
    }

    @Override
    // metodo utilizado para consultar todas as matriculas que foram feitas
    public List<MatriculaResponseDTO> consultarTodasAsMatriculas() {
        List<Matricula> matriculas = repositorioMatricula.findAll();
        return matriculas.stream()
                .map(matricula -> new MatriculaResponseDTO(matricula.getRM_ID(), matricula.getCurso(), matricula.getAluno().getNome(), matricula.getAluno().getRA_ID(), matricula.getTurma().getRT_ID()))
                .collect(Collectors.toList());
    }

    @Override
    // metodo utilizado para consultar uma matricula especifica por "id"
    public MatriculaResponseDTO consultarById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID da matrícula não pode ser nulo");
        }
        Matricula matricula = repositorioMatricula.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matrícula não encontrada com o ID: " + id));
        return new MatriculaResponseDTO(matricula.getRM_ID(), matricula.getCurso(), matricula.getAluno().getNome(), matricula.getAluno().getRA_ID(), matricula.getTurma().getRT_ID());
    }
    
    @Override
    // metodo utilizado para deletar uma matricula especifica por "id"
    public void deletarMatricula(Long id) {
        if (id != null) {
            repositorioMatricula.deleteById(id);
        }else{
            throw new IllegalArgumentException("Matricula não encontradao");
        }
    }
}