package com.gerenciamento.universidade.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamento.universidade.Entidades.Aluno;
import com.gerenciamento.universidade.Service.AlunoServiceImplemente;

@RestController
@RequestMapping("/universidade/alunos")
public class AlunoController {
    
    @Autowired
    private AlunoServiceImplemente alunoServiceImplemente;


    
    @PostMapping("/cadastrarAluno")
    public ResponseEntity<Object> cadastrarAluno(@RequestBody Aluno aluno){

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoServiceImplemente.cadastrarAluno(aluno));
    }

    @GetMapping("/consultarAlunos")
    public ResponseEntity<Object> consultarAlunos(){
        return ResponseEntity.status(HttpStatus.OK).body(alunoServiceImplemente.consultarTodosOsAlunos());
    }

    @GetMapping("/concultarAlunos/{id}")
    public ResponseEntity<Object> consultarAlunoId(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(alunoServiceImplemente.consultarById(id));
    }
}
