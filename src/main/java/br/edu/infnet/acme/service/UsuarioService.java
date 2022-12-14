package br.edu.infnet.acme.service;

import br.edu.infnet.acme.model.Usuario;
import br.edu.infnet.acme.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    // LISTAR USUARIO
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    // CRIAR USUARIO
    public Usuario salvar(Usuario usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = usuario.getPassword();
        String bcryptPassword = encoder.encode(password);
        usuario.setPassword(bcryptPassword);
        return usuarioRepository.save(usuario);
    }

    // EXIBIR USUARIO
    public Usuario exibir(Long id) {
        return usuarioRepository.findById(id).get();
    }

    // ATUALIZAR USUARIO
    public Usuario atualizar(Usuario usuario) {
        return this.salvar(usuario);
    }

    // EXCLUIR USUARIO
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