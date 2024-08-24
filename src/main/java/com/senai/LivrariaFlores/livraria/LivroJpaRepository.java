package com.senai.LivrariaFlores.livraria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroJpaRepository extends JpaRepository<Livro, Long> {
}
