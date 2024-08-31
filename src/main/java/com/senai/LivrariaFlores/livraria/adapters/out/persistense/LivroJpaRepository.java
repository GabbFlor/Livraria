package com.senai.LivrariaFlores.livraria.adapters.out.persistense;

import com.senai.LivrariaFlores.livraria.application.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroJpaRepository extends JpaRepository<Livro, Long> {
}
