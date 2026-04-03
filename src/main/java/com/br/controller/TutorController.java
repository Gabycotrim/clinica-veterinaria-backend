package com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.br.model.Tutor;
import com.br.repository.TutorRepository;

//Controller responsável por disponibilizar os serviços da entidade Tutor.
@RestController

//Define o caminho base da URL.
@RequestMapping("/ctutor")

// Permite acesso de qualquer origem (Insomnia, front-end, etc)
@CrossOrigin(origins="*")
public class TutorController {

    //Injeta automaticamente o Repository
    @Autowired
    private TutorRepository trep;

    //LISTAR - retorna todos os tutores
    @GetMapping
    public List<Tutor> listar(){
        return this.trep.findAll();
    }

    //CONSULTAR - retorna um tutor pelo ID
    @GetMapping("/{id}")
    public Tutor consultar(@PathVariable Long id) {
        return this.trep.findById(id)
                .orElseThrow(() -> new RuntimeException("Tutor não encontrado"));
    }

    //INSERIR - cadastra um novo tutor
    @PostMapping
    public Tutor inserir(@RequestBody Tutor tutor) {
        return this.trep.save(tutor);
    }

    //ALTERAR - atualiza um tutor existente
    @PutMapping("/{id}")
    public Tutor alterar(@PathVariable Long id, @RequestBody Tutor tutor) {

        Tutor existente = this.trep.findById(id)
                .orElseThrow(() -> new RuntimeException("Tutor não encontrado"));

        //Atualiza os dados
        existente.setNome(tutor.getNome());
        existente.setCpf(tutor.getCpf());
        existente.setIdade(tutor.getIdade());
        existente.setPossuiConvenio(tutor.isPossuiConvenio());
        existente.setDataCadastro(tutor.getDataCadastro());

        return this.trep.save(existente);
    }

    //EXCLUIR - remove um tutor pelo ID
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {

        Tutor existente = this.trep.findById(id)
                .orElseThrow(() -> new RuntimeException("Tutor não encontrado"));

        this.trep.delete(existente);
    }
}