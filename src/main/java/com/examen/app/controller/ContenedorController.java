package com.examen.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.examen.app.entity.Contenedor;
import com.examen.app.service.ContenedorService;

@CrossOrigin(origins = "*") 
@Tag(name = "Contenedores", description = "API para gestionar contenedores")
@RestController
@RequestMapping("/contenedores")
public class ContenedorController {
    
    @Autowired
    private ContenedorService contenedorService;

    @GetMapping
    @Operation(summary = "Obtener todos los contenedores", description = "Devuelve una lista de contenedores")
    public List<Contenedor> get() {
        return contenedorService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un contenedor por ID", description = "Busca un contenedor en la base de datos según su ID")
    public Optional<Contenedor> getById(@PathVariable int id) {
        return contenedorService.getById(id);
    }

    @PostMapping
    @Operation(summary = "Registrar un nuevo contenedor", description = "Agrega un nuevo contenedor a la base de datos")
    public Contenedor add(@RequestBody Contenedor contenedor) {
        return contenedorService.save(contenedor);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar un contenedor", description = "Modifica un contenedor existente en la base de datos")
    public Contenedor update(@PathVariable int id, @RequestBody Contenedor contenedor) {
        return contenedorService.update(id, contenedor);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un contenedor", description = "Elimina un contenedor de la base de datos")
    public void delete(@PathVariable int id) {
        contenedorService.delete(id);
    }
}
