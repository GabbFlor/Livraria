package com.senai.LivrariaFlores.livraria.adapters.in.web;

import com.senai.LivrariaFlores.livraria.application.domain.Livro;
import com.senai.LivrariaFlores.livraria.application.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/livros")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LivroController {

    @Autowired
    private LivroService service;

    @PostMapping()
    public Livro criarLivro(@RequestBody Livro livro) {
        Livro resultado = service.criarLivro(livro);
        return resultado;
    }

    @GetMapping
    public List<Livro> listar() {
        return service.getTodosLivros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getLivro(@PathVariable Long id) {
        Livro livro = service.getById(id).orElseThrow(() -> new RuntimeException("Livro not found for this id :: " + id));
        return ResponseEntity.ok().body(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable(value = "id") Long id,
                                                @RequestBody Livro livroDetails) {
        Livro updatedLivro = service.atualizarLivro(id, livroDetails);
        return ResponseEntity.ok(updatedLivro);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteLivro(@PathVariable(value = "id") Long id) {
        service.excluirLivro(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
