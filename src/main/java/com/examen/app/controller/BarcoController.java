package com.examen.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.examen.app.entity.Barco;
import com.examen.app.service.BarcoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@CrossOrigin(origins = "*") 
@Tag(name = "Barcos", description = "API para gestionar barcos")
@RestController
@RequestMapping("/barcos")
public class BarcoController {
    
    @Autowired
    private BarcoService barcoService;

    @GetMapping
    @Operation(summary = "Obtener todos los barcos", description = "Devuelve una lista de barcos")
    public List<Barco> get() {
        return barcoService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un barco por ID", description = "Busca un barco en la base de datos según su ID")
    public Optional<Barco> getById(@PathVariable int id) {
        return barcoService.getById(id);
    }

    @PostMapping
    @Operation(summary = "Registrar un nuevo barco", description = "Agrega un nuevo barco a la base de datos")
    public Barco add(@RequestBody Barco barco) {
        return barcoService.save(barco);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar un barco", description = "Modifica un barco existente en la base de datos")
    public Barco update(@PathVariable int id, @RequestBody Barco barco) {
        return barcoService.update(id, barco);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un barco", description = "Elimina un barco de la base de datos")
    public void delete(@PathVariable int id) {
        barcoService.delete(id);
    }

}
