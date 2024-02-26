package com.example.finalaed.controlador;

import com.example.finalaed.Repositorio.RepositorioPadre;
import com.example.finalaed.mapeado.PadresEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("padres")
public class ControladorPadre {

    @Autowired
    public RepositorioPadre repositorioPadre;

    @GetMapping("")
    public List<PadresEntity> getAllPadres() {
        return repositorioPadre.findAll();
    }

    @PostMapping("")
    public PadresEntity addPadre(@RequestBody PadresEntity nuevoPadre) {
        return repositorioPadre.save(nuevoPadre);
    }



    @PutMapping("/{id}")
    public PadresEntity updatePadre(@PathVariable("id") int id, @RequestBody PadresEntity padreActualizado) {
        PadresEntity padreExistente = repositorioPadre.findById(id).orElse(null);
        if (padreExistente != null) {
            padreExistente.setNombre(padreActualizado.getNombre());
            padreExistente.setApellidos(padreActualizado.getApellidos());
            return repositorioPadre.save(padreExistente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deletePadre(@PathVariable("id") int id) {
        PadresEntity padreExistente = repositorioPadre.findById(id).orElse(null);
        if (padreExistente != null) {
            repositorioPadre.deleteById(id);
            return "Padre con id "+ id +" correctamente";
        }
        return "No se encontró ningún padre con el ID proporcionado";
    }
}
