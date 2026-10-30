package com.qgo.qgobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import com.qgo.qgobackend.repository.UsuarioRepository;
import com.qgo.qgobackend.model.Usuario;
import com.qgo.qgobackend.model.Rol;

@SpringBootApplication
public class QgoBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(QgoBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDemoUsers(UsuarioRepository usuarioRepository) {
        return args -> {
            cargarSiNoExiste(usuarioRepository, "Juan Carlos Castillo", "juan.guatemala@qgo.gt", "123", Rol.CLIENTE);
            cargarSiNoExiste(usuarioRepository, "Sofía Méndez", "sofia.mendez@qgo.gt", "123", Rol.CLIENTE);
            cargarSiNoExiste(usuarioRepository, "Pollo Campero Zona 10", "pedidos@campero.com.gt", "123", Rol.COMERCIO);
            cargarSiNoExiste(usuarioRepository, "McDonald's Las Américas", "pedidos@mcdonalds.com.gt", "123", Rol.COMERCIO);
            cargarSiNoExiste(usuarioRepository, "Pizza Hut Zona Viva", "pedidos@pizzahut.com.gt", "123", Rol.COMERCIO);
            cargarSiNoExiste(usuarioRepository, "Burger King Roosevelt", "pedidos@burgerking.com.gt", "123", Rol.COMERCIO);
            cargarSiNoExiste(usuarioRepository, "Subway Cayalá", "pedidos@subway.com.gt", "123", Rol.COMERCIO);
            cargarSiNoExiste(usuarioRepository, "Domino's Pizza Las Américas", "pedidos@dominos.com.gt", "123", Rol.COMERCIO);
            cargarSiNoExiste(usuarioRepository, "Erick Morales (Repartidor)", "erick.repartidor@qgo.gt", "123", Rol.REPARTIDOR);
            cargarSiNoExiste(usuarioRepository, "Administrador General", "admin@qgo.gt", "admin", Rol.ADMINISTRADOR);
        };
    }

    private void cargarSiNoExiste(UsuarioRepository repo, String nombre, String correo, String clave, Rol rol) {
        boolean existe = repo.findAll().stream().anyMatch(u -> u.getCorreo() != null && u.getCorreo().equalsIgnoreCase(correo));
        if (!existe) {
            Usuario u = new Usuario();
            u.setNombre(nombre);
            u.setCorreo(correo);
            u.setContrasena(clave);
            u.setRol(rol);
            repo.save(u);
        }
    }
}
