package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioJpa;
import br.com.alura.codechella.infra.gateways.UsuarioEntityMapper;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    CriarUsuario criarUsuario(RepositorioDeUsuario repositorio) {
        return new CriarUsuario(repositorio);
    }

    @Bean
    RepositorioDeUsuarioJpa repositorioUsuarioJpa(UsuarioRepository usuarioRepository, UsuarioEntityMapper usuarioEntityMapper) {
        return new RepositorioDeUsuarioJpa(usuarioRepository, usuarioEntityMapper);
    }

    @Bean
    UsuarioEntityMapper usuarioEntityMapper(){
        return new UsuarioEntityMapper();
    }
}
