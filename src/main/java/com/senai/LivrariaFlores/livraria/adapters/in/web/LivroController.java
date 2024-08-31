package com.senai.LivrariaFlores.livraria.adapters.in.web;

import com.senai.LivrariaFlores.livraria.application.domain.Livro;
import com.senai.LivrariaFlores.livraria.application.LivroService;
import com.senai.LivrariaFlores.livraria.application.ports.in.CreateLivroUseCase;
import com.senai.LivrariaFlores.livraria.application.ports.in.DeleteLivroUseCase;
import com.senai.LivrariaFlores.livraria.application.ports.in.GetLivroUseCase;
import com.senai.LivrariaFlores.livraria.application.ports.in.UpdateLivroUseCase;
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

    @Autowired
    private CreateLivroUseCase createLivroUseCase;
    @Autowired
    private DeleteLivroUseCase deleteLivroUseCase;
    @Autowired
    private GetLivroUseCase getLivroUseCase;
    @Autowired
    private UpdateLivroUseCase updateLivroUseCase;

    @PostMapping()
    public Livro criarLivro(@RequestBody Livro livro) {
        Livro resultado = service.cadastrarLivro(livro);
        return resultado;
    }

    @GetMapping
    public List<Livro> listar() {
        return service.getLivros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getLivro(@PathVariable Long id) {
        Livro livro = service.getLivro(id);
        return ResponseEntity.ok().body(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable(value = "id") Long id,
                                                @RequestBody Livro livroDetails) {
        Livro updatedLivro = service.updateLivro(livroDetails, id);
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
