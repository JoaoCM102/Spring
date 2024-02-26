package com.example.finalaed.Repositorio;

import com.example.finalaed.mapeado.PadresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioPadre extends JpaRepository<PadresEntity, Integer> {
    List<PadresEntity> findByNombre(String nombre);

    List<PadresEntity> getPadresEntitiesByPadreId(Integer id);
}
