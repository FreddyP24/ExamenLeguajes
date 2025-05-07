package com.examen.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.app.entity.Barco;
import com.examen.app.repository.BarcoRepository;

@Service
public class BarcoService {
    
    @Autowired
    private BarcoRepository barcoRepository;

    public List<Barco> getAll(){
        return barcoRepository.findAll();
    }

    public Optional<Barco> getById(int id){
        return barcoRepository.findById(id);
    }

    public Barco save(Barco barco){
        return barcoRepository.save(barco);
    }

    public Barco update(int id, Barco barco){
        Optional<Barco> barcoOpt = barcoRepository.findById(id);
        if (barcoOpt.isPresent()) {
            Barco barcoActualizado = barcoOpt.get();
            
            barcoActualizado.setCapacidad(barco.getCapacidad());
            barcoActualizado.setDestino(barco.getDestino());
            barcoActualizado.setNombre(barco.getNombre());
            barcoActualizado.setOrigen(barco.getOrigen());

            return barcoRepository.save(barcoActualizado);
        }else{
            throw new RuntimeException("Barco no encontrado con el ID: " + id);
        }
         }

    public void delete(int id){
        barcoRepository.deleteById(id);
    }
}
