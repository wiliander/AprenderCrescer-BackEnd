package com.meinteressa.meinteressa5.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.meinteressa.meinteressa5.model.Eventos;
import com.meinteressa.meinteressa5.repository.EventosRepository;
import com.meinteressa.meinteressa5.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

//local q vai rodar nossa aplicação em qualquer url no caso localhost:4200 import
@CrossOrigin("*") //importante para o angular
@RestController
@RequestMapping("/eventos")
public class EventosResource {

    @Autowired
    private EventosRepository repository;

    //método raiz retorna todos os eventos
    @JsonIgnoreProperties("eventos")
    @GetMapping("")
    public List<Eventos> lista(){
        return repository.findAll();
    }

    //url mapeada para selecionar um evento
    @GetMapping("/xx")
    public Eventos select(@RequestParam @PathVariable Long id){

        return repository.getOne(id);
    }

    @PostMapping
    public Eventos adicionarEvento(@RequestBody Eventos evento){

        return repository.save(evento);

    }
    //aqui é o id
    @DeleteMapping("/{evento}")
    public void delete(@PathVariable Eventos evento) {
        repository.delete(evento);
    }

    @PutMapping("/edit/{evento}")
    public void atualizar(@RequestBody Eventos evento ){
        repository.save(evento);
    }
}
