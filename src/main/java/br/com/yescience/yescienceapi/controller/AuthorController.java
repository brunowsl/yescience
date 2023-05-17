package br.com.yescience.yescienceapi.controller;

import br.com.yescience.yescienceapi.model.Author;
import br.com.yescience.yescienceapi.repository.AuthorRepository;
import br.com.yescience.yescienceapi.requests.SalvarAuthorRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/author")
public class AuthorController {

    private final AuthorRepository repository;

    @GetMapping("/listar-todos")
    public ResponseEntity<?> listarTodos() {
        var response = repository.findAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        var response = repository.findById(id);
        if (response.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody SalvarAuthorRequest request) {
        var author = new Author();
        author.setNome(request.getNome());
        author.setEmail(request.getEmail());
        author.setQualificacao(request.getQualificacao());
        var autorSalvo = repository.save(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(autorSalvo);
    }


}
