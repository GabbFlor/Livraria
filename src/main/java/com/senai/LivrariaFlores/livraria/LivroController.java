package com.senai.LivrariaFlores.livraria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

//    cria a referência para ser possível de chamar o service do livro
//    @Autowired é injeção de dependência
    @Autowired
    private LivroService service;

    @PostMapping()
    public Livro criarlivro(@RequestBody Livro livro) {
        service.createLivro(livro);
//        System.out.println(livro.getNome());
        return null;
    }

    @GetMapping
    public List<Livro> listar() {
        return service.getAllLivros();
    }

}
