package com.example.finalaed.mapeado;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "padres", schema = "familia", catalog = "")
public class PadresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PadreID", nullable = false)
    private int padreId;
    @Basic
    @Column(name = "Nombre", nullable = true, length = 50)
    private String nombre;
    @Basic
    @Column(name = "Apellidos", nullable = true, length = 50)
    private String apellidos;
    @Basic
    @Column(name = "Imagen", nullable = true, length = 255)
    private String imagen;

    @JsonIgnore
    @OneToMany(mappedBy = "padresByPadreId")
    private Collection<HijosEntity> hijosByPadreId;

    public int getPadreId() {
        return padreId;
    }

    public void setPadreId(int padreId) {
        this.padreId = padreId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PadresEntity that = (PadresEntity) o;

        if (padreId != that.padreId) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (apellidos != null ? !apellidos.equals(that.apellidos) : that.apellidos != null) return false;
        if (imagen != null ? !imagen.equals(that.imagen) : that.imagen != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = padreId;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        result = 31 * result + (imagen != null ? imagen.hashCode() : 0);
        return result;
    }

    public Collection<HijosEntity> getHijosByPadreId() {
        return hijosByPadreId;
    }

    public void setHijosByPadreId(Collection<HijosEntity> hijosByPadreId) {
        this.hijosByPadreId = hijosByPadreId;
    }
}
