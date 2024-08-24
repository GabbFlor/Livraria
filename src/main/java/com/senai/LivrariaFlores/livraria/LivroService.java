package com.senai.LivrariaFlores.livraria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroJpaRepository repository;


    public Optional<Livro> getById(Long id) {
        return repository.findById(id);
    }

    public Livro criarLivro(Livro livro) {
        return repository.save(livro);
    }

    public List<Livro> getTodosLivros() {
        return repository.findAll();
    }

    public Livro atualizarLivro(Long id, Livro livroDetails) {
        Livro livro = repository.findById(id).orElseThrow(() -> new RuntimeException("Livro not found for this id :: " + id));

        livro.setFotoCapa(livroDetails.getFotoCapa());
        livro.setNome(livroDetails.getNome());
        livro.setAutor(livroDetails.getAutor());
        livro.setAno(livroDetails.getAno());
        livro.setExemplares(livroDetails.getExemplares());

        return repository.save(livro);
    }

    public void excluirLivro(Long id) {
        Livro livro = repository.findById(id).orElseThrow(() -> new RuntimeException("Livro not found for this id :: " + id));
        repository.delete(livro);
    }

}
