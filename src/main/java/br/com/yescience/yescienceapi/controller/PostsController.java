package br.com.yescience.yescienceapi.controller;

import br.com.yescience.yescienceapi.model.Posts;
import br.com.yescience.yescienceapi.repository.AuthorRepository;
import br.com.yescience.yescienceapi.repository.PostRepository;
import br.com.yescience.yescienceapi.requests.SalvarPostsRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/posts")
public class PostsController {
    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;

    @GetMapping("/listar-todos")
    public ResponseEntity<?> listarTodos() {
        System.out.println("listar-todos");
        var response = postRepository.findAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        var response = postRepository.findById(id);
        if (response.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody SalvarPostsRequest request) {
        var posts = new Posts();
        posts.setTitulo(request.getTitulo());
        posts.setConteudo(request.getConteudo());
        posts.setImagem(request.getImagem());
        var author = authorRepository.findById(request.getAuthorId());

        if (author.isEmpty())
            return ResponseEntity.notFound().build();

        posts.setAuthor(author.get());

        var postsSalvo = postRepository.save(posts);
        return ResponseEntity.status(HttpStatus.CREATED).body(postsSalvo);
    }
}
