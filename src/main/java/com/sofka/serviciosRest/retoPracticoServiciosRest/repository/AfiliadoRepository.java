package com.sofka.serviciosRest.retoPracticoServiciosRest.repository;

import com.sofka.serviciosRest.retoPracticoServiciosRest.entity.Afiliados;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AfiliadoRepository extends JpaRepository<Afiliados, Long> {
    Optional<Object> findByCedula(String cedula);
}
