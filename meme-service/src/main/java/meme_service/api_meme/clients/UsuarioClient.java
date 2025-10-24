package meme_service.api_meme.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario-client", url = "http://localhost:8081/usuarios")
public interface UsuarioClient {

    @GetMapping("/{id}")
    ResponseEntity<Void> buscaUsuarioPorId(@PathVariable("id") String id);
}
