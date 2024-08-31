package com.senai.LivrariaFlores.livraria.application;

import com.senai.LivrariaFlores.livraria.application.domain.Livro;
import com.senai.LivrariaFlores.livraria.adapters.out.persistense.LivroJpaRepository;
import com.senai.LivrariaFlores.livraria.application.ports.in.CreateLivroUseCase;
import com.senai.LivrariaFlores.livraria.application.ports.in.DeleteLivroUseCase;
import com.senai.LivrariaFlores.livraria.application.ports.in.GetLivroUseCase;
import com.senai.LivrariaFlores.livraria.application.ports.in.UpdateLivroUseCase;
import com.senai.LivrariaFlores.livraria.application.ports.out.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService implements CreateLivroUseCase, DeleteLivroUseCase, GetLivroUseCase, UpdateLivroUseCase {

    @Autowired
    private LivroRepository repository;

    public void excluirLivro(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Livro cadastrarLivro(Livro livro) {
        return repository.save(livro);
    }

    @Override
    public void deleteLivro(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Livro> getLivros() {
        return repository.findAll();
    }

    @Override
    public Livro getLivro(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Livro updateLivro(Livro livroDetails, Long id) {
        Livro livro = repository.findById(id).orElseThrow(() -> new RuntimeException("Livro not found for this id :: " + id));

        livro.setFotoCapa(livroDetails.getFotoCapa());
        livro.setNome(livroDetails.getNome());
        livro.setAutor(livroDetails.getAutor());
        livro.setAno(livroDetails.getAno());
        livro.setExemplares(livroDetails.getExemplares());

        return repository.save(livro);
    }
}
