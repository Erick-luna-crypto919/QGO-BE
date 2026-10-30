package com.qgo.qgobackend.controller;

import org.springframework.web.bind.annotation.*;
import com.qgo.qgobackend.service.UsuarioService;
import com.qgo.qgobackend.model.Usuario;
import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/api/usuarios")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @GetMapping("/api/usuarios")
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @PutMapping("/api/usuarios/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.obtenerPorId(id)
            .map(existente -> {
                if (usuario.getNombre() != null) existente.setNombre(usuario.getNombre());
                if (usuario.getCorreo() != null) existente.setCorreo(usuario.getCorreo());
                if (usuario.getContrasena() != null) existente.setContrasena(usuario.getContrasena());
                if (usuario.getRol() != null) existente.setRol(usuario.getRol());
                return ResponseEntity.ok(usuarioService.guardarUsuario(existente));
            })
            .orElseGet(() -> {
                usuario.setId(id);
                return ResponseEntity.ok(usuarioService.guardarUsuario(usuario));
            });
    }

    @DeleteMapping("/api/usuarios/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}