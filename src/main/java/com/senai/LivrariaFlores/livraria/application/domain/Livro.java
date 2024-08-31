package com.senai.LivrariaFlores.livraria.application.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Livro {
    private Long id;
    private String fotoCapa;
    private String nome;
    private String autor;
    private Integer ano;
    private Integer exemplares;
}
