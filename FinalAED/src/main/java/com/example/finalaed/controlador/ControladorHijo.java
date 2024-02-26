package com.example.finalaed.controlador;

import com.example.finalaed.Repositorio.RepositorioHijo;
import com.example.finalaed.Repositorio.RepositorioPadre;
import com.example.finalaed.mapeado.HijosEntity;
import com.example.finalaed.mapeado.PadresEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("hijos")
public class ControladorHijo {

    public RepositorioPadre repositorioPadre;
    public RepositorioHijo repositorioHijo;


    @Autowired
    public ControladorHijo(RepositorioPadre repositorioPadre, RepositorioHijo repositorioHijo) {
        this.repositorioPadre = repositorioPadre;
        this.repositorioHijo = repositorioHijo;
    }

    @GetMapping("")
    public List<HijosEntity> getAllHijos() {
        return repositorioHijo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<HijosEntity> getHijoById(@PathVariable Integer id) {
        return repositorioHijo.findById(id);
    }

    @PostMapping("")
    public HijosEntity addHijo(@RequestBody HijosEntity hijo) {
        return repositorioHijo.save(hijo);
    }

    @PostMapping("/SubirHijoConEnlacePadre/{id}")
    public HijosEntity addHijo(@PathVariable("id") int padreId, @RequestBody HijosEntity nuevoHijo) {
        PadresEntity padre = repositorioPadre.findById(padreId).orElse(null);
        if (padre != null) {
            nuevoHijo.setPadresByPadreId(padre);
            return repositorioHijo.save(nuevoHijo);
        } else {

            return null;
        }
    }


    @PutMapping("/{id}")
    public HijosEntity updateHijo(@PathVariable Integer id, @RequestBody HijosEntity nuevoHijo) {
        if (repositorioHijo.existsById(id)) {
            nuevoHijo.setHijoId(id);
            return repositorioHijo.save(nuevoHijo);
        } else {

            return null;
        }
    }

    @PutMapping("/{id}/Con/{idPadre}")
    public HijosEntity updateHijoWithPadre(@PathVariable Integer id, @PathVariable Integer idPadre) {
        Optional<HijosEntity> optionalHijo = repositorioHijo.findById(id);
        if (optionalHijo.isPresent()) {
            HijosEntity hijo = optionalHijo.get();
            Optional<PadresEntity> optionalPadre = repositorioPadre.findById(idPadre);
            if (optionalPadre.isPresent()) {
                PadresEntity padre = optionalPadre.get();
                hijo.setPadresByPadreId(padre);
                return repositorioHijo.save(hijo);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


    @DeleteMapping("/{id}")
    public void deleteHijo(@PathVariable Integer id) {
        repositorioHijo.deleteById(id);
    }

}
