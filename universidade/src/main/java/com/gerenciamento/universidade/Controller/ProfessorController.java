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

// controlador do fluxo de servicos para a entidade "professor"
@RestController
// raiz da requisicao feita por um usuario sobre a entidade "professor"
@RequestMapping("/universidade/professor") 
public class ProfessorController {
    
    @Autowired
    private ProfessorServiceImplemente professorServiceImplemente;

    // faz uma requisicao ao sistema para cadastrar um novo professor
    @PostMapping("/cadastrarProfessor")
    public ResponseEntity<Object> cadastrarProfessor(@RequestBody Professor professor){

        return ResponseEntity.status(HttpStatus.CREATED).body(professorServiceImplemente.cadastrarProfessor(professor));
    }

    // faz uma requisicao ao sistema para consultar os professores
    @GetMapping("/consultarProfessores")
    public ResponseEntity<Object> consultarAlunos(){
        return ResponseEntity.status(HttpStatus.OK).body(professorServiceImplemente.consultarTodosOsProfessores());
    }

    // faz uma requisicao ao sistema para consultar um professor especifico por "id"
    @GetMapping("/consultarProfessor/{id}")
    public ResponseEntity<Object> consultarProfessorId(@PathVariable(value = "id") Long id){

        return ResponseEntity.status(HttpStatus.OK).body(professorServiceImplemente.consultarById(id));
    }

    // faz uma requisicao ao sistema para deletar um professor especifico de acordo com o "id"
    @DeleteMapping("/deletarProfessor/{id}")
    public ResponseEntity<Object> deletarProfessor(@PathVariable(value = "id") Long id){
        professorServiceImplemente.deletarProfessor(id);
        return ResponseEntity.status(HttpStatus.OK).body("Professor deletado");
    }
}
