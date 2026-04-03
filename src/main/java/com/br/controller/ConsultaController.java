package com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.br.model.Consulta;
import com.br.repository.ConsultaRepository;

//Controller responsável por disponibilizar os serviços da entidade Consulta.
@RestController

//Define o caminho base da URL.
@RequestMapping("/cconsulta")

//Permite acesso de qualquer origem (Insomnia, front-end, etc)
@CrossOrigin(origins="*")
public class ConsultaController {

	//Injeta automaticamente o Repository
    @Autowired
    private ConsultaRepository crep;

    //LISTAR - retorna todas as consultas
    @GetMapping
    public List<Consulta> listar(){
        return this.crep.findAll();
    }

    //CONSULTAR - retorna uma consulta pelo ID
    @GetMapping("/{id}")
    public Consulta consultar(@PathVariable Long id) {
        return this.crep.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    }

    //INSERIR - cadastra uma nova consulta
    @PostMapping
    public Consulta inserir(@RequestBody Consulta consulta) {
        return this.crep.save(consulta);
    }

    //ALTERAR - atualiza uma consulta existente
    @PutMapping("/{id}")
    public Consulta alterar(@PathVariable Long id, @RequestBody Consulta consulta) {

        Consulta existente = this.crep.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        existente.setDataConsulta(consulta.getDataConsulta());
        existente.setProntuario(consulta.getProntuario());
        existente.setQuantidadeDiasTratamento(consulta.getQuantidadeDiasTratamento());
        existente.setValorConsulta(consulta.getValorConsulta());
        existente.setRetorno(consulta.isRetorno());

        return this.crep.save(existente);
    }

    //EXCLUIR - remove uma consulta pelo ID
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {

        Consulta existente = this.crep.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        this.crep.delete(existente);
    }
}