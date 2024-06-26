package com.gerenciamento.universidade.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gerenciamento.universidade.Entidades.Aluno;
import com.gerenciamento.universidade.Service.AlunoServiceImplemente;

// controlador do fluxo de servicos para a entidade "aluno"
@RestController
// raiz da requisicao feita por um usuario sobre a entidade "aluno"
@RequestMapping("/universidade/alunos")
public class AlunoController {
    
    @Autowired
    private AlunoServiceImplemente alunoServiceImplemente;
    
    // faz uma requisicao ao sistema para cadastrar um novo aluno
    @PostMapping("/cadastrarAluno")
    public ResponseEntity<Object> cadastrarAluno(@RequestBody Aluno aluno){

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoServiceImplemente.cadastrarAluno(aluno));
    }

    // faz uma requisicao ao sistema para consultar os alunos
    @GetMapping("/consultarAlunos")
    public ResponseEntity<Object> consultarAlunos(){
        return ResponseEntity.status(HttpStatus.OK).body(alunoServiceImplemente.consultarTodosOsAlunos());
    }

    // faz uma requisicao ao sistema para consultar um aluno especifico por "id"
    @GetMapping("/consultarAluno/{id}")
    public ResponseEntity<Object> consultarAlunoId(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(alunoServiceImplemente.consultarById(id));
    }

    // faz uma requisicao ao sistema para deletar um aluno especifico por "id"
    @DeleteMapping("/deletarAluno/{id}")
    public ResponseEntity<Object> deletarAluno(@PathVariable(value = "id") Long id){
        alunoServiceImplemente.deletarAluno(id);
        return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado");
    }
}
