package com.senai.LivrariaFlores.livraria.adapters.out.persistense;

import com.senai.LivrariaFlores.livraria.application.domain.Livro;
import com.senai.LivrariaFlores.livraria.application.ports.out.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class LivroRepositoryImp implements LivroRepository {

    @Autowired
    private LivroJpaRepository livroJpaRepository;

    @Override
    public List<Livro> findAll() {
        return livroJpaRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Livro> findById(Long id) {
        return livroJpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public Livro save(Livro livro) {
        LivroEntity livroEntity = toEntity(livro);
        return toDomain(livroJpaRepository.save(livroEntity));
    }

    @Override
    public void deleteById(Long id) {
        livroJpaRepository.deleteById(id);
    }

    private Livro toDomain(LivroEntity entity) {
        Livro livro = new Livro();
        livro.setId(entity.getId());
        livro.setFotoCapa(entity.getFotoCapa());
        livro.setNome(entity.getNome());
        livro.setAutor(entity.getAutor());
        livro.setAno(entity.getAno());
        livro.setExemplares(entity.getExemplares());
        return livro;
    }

    private LivroEntity toEntity(Livro livro) {
        LivroEntity entity = new LivroEntity();
        entity.setId(livro.getId());
        entity.setFotoCapa(livro.getFotoCapa());
        entity.setNome(livro.getNome());
        entity.setAutor(livro.getAutor());
        entity.setAno(livro.getAno());
        entity.setExemplares(livro.getExemplares());
        return entity;
    }
}
