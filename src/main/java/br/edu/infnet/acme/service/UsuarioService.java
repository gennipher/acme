package br.edu.infnet.acme.service;

import br.edu.infnet.acme.model.Usuario;
import br.edu.infnet.acme.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    // Listar
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    // criar
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // exibir
    public Usuario exibir(Long id) {
        return usuarioRepository.findById(id).get();
    }

    // atualizar
    public Usuario atualizar(Usuario usuario) {
        return this.salvar(usuario);
    }

    // EXCLUIR
    public boolean excluir(Long id) {

        try {
            usuarioRepository.deleteById(id);
            return false;
        } catch(Exception e) {
            e.printStackTrace();
            return true;
        }
    }

}