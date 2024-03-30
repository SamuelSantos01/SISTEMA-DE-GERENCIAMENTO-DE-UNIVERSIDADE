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
import com.gerenciamento.universidade.Entidades.Professor;
import com.gerenciamento.universidade.Service.ProfessorServiceImplemente;

@RestController
@RequestMapping("/universidade/professor")
public class ProfessorController {
    
    @Autowired
    private ProfessorServiceImplemente professorServiceImplemente;

    @PostMapping("/cadastrarProfessor")
    public ResponseEntity<Object> cadastrarProfessor(@RequestBody Professor professor){

        return ResponseEntity.status(HttpStatus.CREATED).body(professorServiceImplemente.cadastrarProfessor(professor));
    }

    @GetMapping("/consultarProfessores")
    public ResponseEntity<Object> consultarAlunos(){
        return ResponseEntity.status(HttpStatus.OK).body(professorServiceImplemente.consultarTodosOsProfessores());
    }


    @GetMapping("/consultarProfessor/{id}")
    public ResponseEntity<Object> consultarProfessorId(@PathVariable(value = "id") Long id){

        return ResponseEntity.status(HttpStatus.OK).body(professorServiceImplemente.consultarById(id));
    }

    @DeleteMapping("/deletarProfessor/{id}")
    public ResponseEntity<Object> deletarProfessor(@PathVariable(value = "id") Long id){
        professorServiceImplemente.deletarProfessor(id);
        return ResponseEntity.status(HttpStatus.OK).body("Professor deletado");
    }
}
