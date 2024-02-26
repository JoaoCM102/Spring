package com.example.finalaed.Repositorio;

import com.example.finalaed.mapeado.HijosEntity;
import com.example.finalaed.mapeado.PadresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioHijo extends JpaRepository<HijosEntity, Integer> {
    List<HijosEntity> findByNombre(String nombre);

    List<HijosEntity> getHijoByHijoId(Integer hijoId);

}
