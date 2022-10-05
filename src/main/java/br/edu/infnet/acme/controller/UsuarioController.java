package br.edu.infnet.acme.controller;

import br.edu.infnet.acme.model.Usuario;
import br.edu.infnet.acme.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    // LISTAR TODOS
    @GetMapping
    public ResponseEntity listar() {

        var usuarios = usuarioService.listar();
        if (usuarios.isEmpty())
            return ResponseEntity.ok().body("Lista Vazia");

        return ResponseEntity.ok().body(usuarios);
    }

    // LISTAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity exibir(@PathVariable("id") long id) {

        var usuario = usuarioService.exibir(id);
        return ResponseEntity.ok().body(usuario);
    }

    // CADASTRAR USUARIO
    @PostMapping()
    public ResponseEntity inserir(@RequestBody Usuario usuario) {
        if (usuario.getUsername() == null || usuario.getEmail() == null || usuario.getPassword() == null)
            return ResponseEntity.status(400).body("Username, Email e Senha são obrigatórios.");

        usuario = usuarioService.salvar(usuario);
        if (usuario.getId() != 0)
            return ResponseEntity.ok().body(usuario);

        return ResponseEntity.status(500).body("Erro interno.");
    }


    // ATUALIZAR USUARIO
    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (usuario.getUsername() == null || usuario.getEmail() == null || usuario.getPassword() == null)
            return ResponseEntity.status(400).body("Atualize pelo menos um dos campos: Username, Email ou Password.");
        usuario.setId(id);
        usuario = usuarioService.salvar(usuario);
        return ResponseEntity.status(201).body(usuario);
    }


    // REMOVER USUARIO
    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable("id") long id) {

        boolean resultado = usuarioService.excluir(id);
        if(resultado) {
            return ResponseEntity.ok().body("Usuário excluido.");
        } else {
            return ResponseEntity.internalServerError().body("Erro ao excluir.");
        }
    }
}
