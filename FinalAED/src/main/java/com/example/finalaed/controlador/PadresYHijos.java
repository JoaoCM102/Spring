package com.example.finalaed.controlador;
import com.example.finalaed.mapeado.HijosEntity;
import com.example.finalaed.mapeado.PadresEntity;

import java.util.List;

public class PadresYHijos {
    private PadresEntity padre;
    private List<HijosEntity> hijos;

    public PadresYHijos() {}

    public PadresYHijos(PadresEntity padre, List<HijosEntity> hijos) {
        this.padre = padre;
        this.hijos = hijos;
    }

    public List<HijosEntity> getHijos() {
        return hijos;
    }

    public void setHijos(List<HijosEntity> hijos) {
        this.hijos = hijos;
    }

    public PadresEntity getPadre() {
        return padre;
    }

    public void setPadre(PadresEntity padre) {
        this.padre = padre;
    }
}
