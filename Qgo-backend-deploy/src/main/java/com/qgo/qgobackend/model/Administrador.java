package com.qgo.qgobackend.model;

public class Administrador extends Usuario {

    public Administrador(Long id, String nombre, String correo, String contrasena, Rol rol) {
        super(id, nombre, correo, contrasena, rol);
    }

}
