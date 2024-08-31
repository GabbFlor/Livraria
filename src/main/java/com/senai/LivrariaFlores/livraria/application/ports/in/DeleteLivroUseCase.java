package com.senai.LivrariaFlores.livraria.application.ports.in;

import com.senai.LivrariaFlores.livraria.application.domain.Livro;

public interface DeleteLivroUseCase {
    Livro deleteLivro(Long id);
}
