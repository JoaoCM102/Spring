package com.example.finalaed.mapeado;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
@Table(name = "hijos", schema = "familia", catalog = "")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "hijoId")
public class HijosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "HijoID", nullable = false)
    private int hijoId;
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
    @ManyToOne
    @JoinColumn(name = "PadreID", referencedColumnName = "PadreID")
    private PadresEntity padresByPadreId;

    public int getHijoId() {
        return hijoId;
    }

    public void setHijoId(int hijoId) {
        this.hijoId = hijoId;
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

        HijosEntity that = (HijosEntity) o;

        if (hijoId != that.hijoId) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (apellidos != null ? !apellidos.equals(that.apellidos) : that.apellidos != null) return false;
        if (imagen != null ? !imagen.equals(that.imagen) : that.imagen != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hijoId;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        result = 31 * result + (imagen != null ? imagen.hashCode() : 0);
        return result;
    }

    public PadresEntity getPadresByPadreId() {
        return padresByPadreId;
    }

    public void setPadresByPadreId(PadresEntity padresByPadreId) {
        this.padresByPadreId = padresByPadreId;
    }
}
