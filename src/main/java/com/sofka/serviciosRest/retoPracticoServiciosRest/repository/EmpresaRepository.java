package com.sofka.serviciosRest.retoPracticoServiciosRest.repository;

import com.sofka.serviciosRest.retoPracticoServiciosRest.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
