package com.senai.LivrariaFlores.livraria.application.ports.in;

import com.senai.LivrariaFlores.livraria.application.domain.Livro;

import java.util.List;

public interface GetLivroUseCase {
    List<Livro> getLivros();

    Livro getLivro(Long id);
}
