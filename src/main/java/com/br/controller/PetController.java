package com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.br.model.Pet;
import com.br.repository.PetRepository;

//Controller responsável por disponibilizar os serviços da entidade Pet.
@RestController

//Define o caminho base da URL.
@RequestMapping("/cpet")

//Permite acesso de qualquer origem (Insomnia, front-end, etc)
@CrossOrigin(origins="*")
public class PetController {

	//Injeta automaticamente o Repository
    @Autowired
    private PetRepository prep;

    //LISTAR - retorna todos os pets
    @GetMapping
    public List<Pet> listar(){
        return this.prep.findAll();
    }

    //CONSULTAR - retorna um pet pelo ID
    @GetMapping("/{id}")
    public Pet consultar(@PathVariable Long id) {
        return this.prep.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));
    }

    //INSERIR - cadastra um novo pet
    @PostMapping
    public Pet inserir(@RequestBody Pet pet) {
        return this.prep.save(pet);
    }

    //ALTERAR - atualiza um pet existente
    @PutMapping("/{id}")
    public Pet alterar(@PathVariable Long id, @RequestBody Pet pet) {

        Pet existente = this.prep.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));

        existente.setNome(pet.getNome());
        existente.setEspecie(pet.getEspecie());
        existente.setIdade(pet.getIdade());
        existente.setVacinado(pet.isVacinado());
        existente.setDataNascimento(pet.getDataNascimento());

        return this.prep.save(existente);
    }

    //EXCLUIR - remove um pet pelo ID
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {

        Pet existente = this.prep.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));

        this.prep.delete(existente);
    }
}