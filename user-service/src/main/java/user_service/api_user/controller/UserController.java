package user_service.api_user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user_service.api_user.entities.Usuario;
import user_service.api_user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Usuario criaUsuario(@RequestBody Usuario usuario) {
        return userService.novoUsuario(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable String id) {
        return userService.getUsuarioById(id).map(usuario -> ResponseEntity.ok(usuario))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Usuario> listaTodosUsuarios() { return userService.listaTodosUsuarios(); }
}
