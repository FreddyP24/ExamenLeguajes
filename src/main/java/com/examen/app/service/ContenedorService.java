package com.examen.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.app.entity.Contenedor;
import com.examen.app.repository.ContenedorRepository;

import java.util.List;
import java.util.Optional; 
@Service 
public class ContenedorService { 

    @Autowired
    private ContenedorRepository contenedorRepository;

    public List<Contenedor> getAll(){
        return contenedorRepository.findAll();
    }

    public Optional<Contenedor> getById(int id){
        return contenedorRepository.findById(id);
    }

    public Contenedor save(Contenedor contenedor){
        return contenedorRepository.save(contenedor);
    }

    public Contenedor update(int id, Contenedor contenedor){
        Optional<Contenedor> contenedorOpt = contenedorRepository.findById(id);
        if (contenedorOpt.isPresent()) {
            Contenedor contenedorActualizado = contenedorOpt.get();

            contenedorActualizado.setVin(contenedor.getVin());
            contenedorActualizado.setIdBarco(contenedor.getIdBarco());
            contenedorActualizado.setFecha(contenedor.getFecha());

            return contenedorRepository.save(contenedorActualizado);
        }else{
            throw new RuntimeException("Contenedor no encontrado con el ID: " + id);
        }
         }

    public void delete(int id){
        contenedorRepository.deleteById(id);
    }
} 
