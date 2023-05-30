package com.br.global.apialimentos.service;

import com.br.global.apialimentos.domain.Usuario;
import com.br.global.apialimentos.domain.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> todosUsuariosAtivos(){
        return usuarioRepository.findAllByAtivoTrue();
    }

    public Usuario loginUsuario(String email, String senha){
        return usuarioRepository.findByEmailAndSenha(email, senha);
    }

}
