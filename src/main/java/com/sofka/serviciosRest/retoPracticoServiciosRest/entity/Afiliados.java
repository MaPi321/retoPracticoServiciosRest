package com.sofka.serviciosRest.retoPracticoServiciosRest.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "afiliados")
public class Afiliados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_afiliado")
    private Long idAfiliado;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "cedula")
    private String cedula;

    @Column(name = "empresa_id")
    private Long empresaId;

    public Long getIdAfiliado() {
        return idAfiliado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public Long getEmpresaId() {
        return empresaId;
    }

    public void setIdAfiliado(Long idAfiliado) {
        this.idAfiliado = idAfiliado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
    }
}
