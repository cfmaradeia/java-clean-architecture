package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

import java.util.List;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repository;
    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository repository, UsuarioEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity usuarioEntity = mapper.toEntity(usuario);
        UsuarioEntity usuarioSalvo = repository.save(usuarioEntity);
        return mapper.toDomain(usuarioSalvo);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public Usuario alterarUsuario(String cpf, Usuario usuario) {
        UsuarioEntity entity = repository.findByCpf(cpf);
        if(entity != null) {
            UsuarioEntity usuarioAtualizado = mapper.toEntity(usuario);
            usuarioAtualizado.setId(entity.getId());
            return mapper.toDomain(repository.saveAndFlush(usuarioAtualizado));
        }
        return null;
    }

    @Override
    public void removerUsuario(String cpf) {
        UsuarioEntity usuarioEntity = repository.findByCpf(cpf);
        repository.delete(usuarioEntity);
    }
}
