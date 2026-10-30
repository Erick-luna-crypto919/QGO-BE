package com.qgo.qgobackend.model;

public class Repartidor extends Usuario {

    public Repartidor(Long id, String nombre, String correo, String contrasena, Rol rol) {
        super(id, nombre, correo, contrasena, rol);
    }

    public void actualizarEstadoEntrega() {
        System.out.println("El repartidor puede actualizar el estado de la entrega.");
    }
}
