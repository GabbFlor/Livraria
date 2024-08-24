package com.senai.LivrariaFlores.livraria;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PostMapping()
    public Livro createlivro(@RequestBody Livro livro) {
        System.out.println(livro.getNome());
        return null;
    }

}
