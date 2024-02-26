package com.example.finalaed.controlador;

import com.example.finalaed.Repositorio.RepositorioHijo;
import com.example.finalaed.Repositorio.RepositorioPadre;
import com.example.finalaed.mapeado.HijosEntity;
import com.example.finalaed.mapeado.PadresEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
public class ControladorAmbos {
    public RepositorioPadre repositorioPadre;
    public RepositorioHijo repositorioHijo;

    @Autowired
    public ControladorAmbos(RepositorioPadre repositorioPadre, RepositorioHijo repositorioHijo) {
        this.repositorioPadre = repositorioPadre;
        this.repositorioHijo = repositorioHijo;
    }

    @GetMapping("")
    public List<PadresYHijos> getList() {
        List<PadresEntity> padres = repositorioPadre.findAll();
        List<PadresYHijos> padresConHijos = new ArrayList<>();
        for (PadresEntity padre : padres) {
            List<HijosEntity> hijos = (List<HijosEntity>) padre.getHijosByPadreId();
            padresConHijos.add(new PadresYHijos(padre, hijos));
        }
        return padresConHijos;
    }


}
