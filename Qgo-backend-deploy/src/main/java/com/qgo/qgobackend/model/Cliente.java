package com.qgo.qgobackend.model;

public class Cliente extends Usuario {

    public Cliente(Long id, String nombre, String correo, String contrasena, Rol rol) {
        super(id, nombre, correo, contrasena, rol);
    }
    public void realizarPedido() {
        System.out.println("El cliente puede realizar un pedido.");
    }
}
