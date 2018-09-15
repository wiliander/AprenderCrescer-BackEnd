package com.meinteressa.meinteressa5.service;

import com.meinteressa.meinteressa5.model.Eventos;
import com.meinteressa.meinteressa5.repository.EventosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    //precisa para add no banco
    @Autowired
    private EventosRepository eventos;


    public Eventos adicionar(Eventos evento){
        return eventos.save(evento);
    }
}
