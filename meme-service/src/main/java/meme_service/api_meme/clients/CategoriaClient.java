package meme_service.api_meme.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "categoria-client", url = "http://localhost:8082/categorias")
public interface CategoriaClient {

    @GetMapping("/{id}")
    ResponseEntity<Void> buscaCategoriaPorId(@PathVariable String id);
}
