package com.gerenciamento.universidade.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamento.universidade.Entidades.Aluno;
import com.gerenciamento.universidade.Entidades.Matricula;
import com.gerenciamento.universidade.Entidades.Turma;
import com.gerenciamento.universidade.Interfaces.MatriculaService;
import com.gerenciamento.universidade.Repositorio.RepositorioAluno;
import com.gerenciamento.universidade.Repositorio.RepositorioMatricula;
import com.gerenciamento.universidade.Repositorio.RepositorioTurma;

@Service
public class MatriculaServiceImplemente implements MatriculaService {

    @Autowired
    private RepositorioAluno repositorioAluno;

    @Autowired
    private RepositorioTurma repositorioTurma;

    @Autowired
    private RepositorioMatricula repositorioMatricula;

    @Override
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
    public List<Matricula> consultarTodasAsMatriculas() {
        List<Matricula> matriculas = repositorioMatricula.findAll();
        return matriculas;
    }

    @Override
    public Matricula consultarById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID da matrícula não pode ser nulo");
        }
        return repositorioMatricula.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matrícula não encontrada com o ID: " + id));
    }
    
    @Override
    public void deletarMatricula(Long id) {
        if (id != null) {
            repositorioMatricula.deleteById(id);
        }else{
            throw new IllegalArgumentException("Matricula não encontradao");
        }
    }
    
}
