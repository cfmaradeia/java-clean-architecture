package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class RemoverUsuario {

    private final RepositorioDeUsuario repositorio;

    public RemoverUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public void removerUsuario(String cpf) {
        repositorio.removerUsuario(cpf);
    }
}
