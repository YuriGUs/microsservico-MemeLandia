package meme_service.api_meme.service;

import feign.FeignException;
import meme_service.api_meme.clients.CategoriaClient;
import meme_service.api_meme.clients.UsuarioClient;
import meme_service.api_meme.entities.Meme;
import meme_service.api_meme.repository.MemeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MemeService {

    private static final Logger logger = LoggerFactory.getLogger(MemeService.class);

    private final MemeRepository memeRepository;
    private final UsuarioClient usuarioClient;
    private final CategoriaClient categoriaClient;

    public MemeService(MemeRepository memeRepository, UsuarioClient usuarioClient, CategoriaClient categoriaClient) {
        this.memeRepository = memeRepository;
        this.usuarioClient = usuarioClient;
        this.categoriaClient = categoriaClient;
    }

    public List<Meme> listaTodosMemes() {
        return memeRepository.findAll();
    }

    public Meme criarMeme(Meme novoMeme) {
        logger.info("Iniciando processo de criação de meme: {}", novoMeme.getNome());
        try {
            logger.info("Validando usuário com ID: {}", novoMeme.getUsuarioId());
            ResponseEntity<Void> response = usuarioClient.buscaUsuarioPorId(novoMeme.getUsuarioId());
            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new RuntimeException("Usuário não encontrado com o ID: " + novoMeme.getUsuarioId());
            }
            logger.info("Usuário validado com sucesso.");
        } catch (FeignException.NotFound e) {
            logger.error("Falha na validação: Usuário não encontrado com ID: {}", novoMeme.getUsuarioId());
            throw new RuntimeException("Usuário não encontrado com o ID: " + novoMeme.getUsuarioId());
        }

        try {
            logger.info("Validando categoria com ID: {}", novoMeme.getCategoriaMemeId());
            ResponseEntity<Void> response = categoriaClient.buscaCategoriaPorId(novoMeme.getCategoriaMemeId());
            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new RuntimeException("Categoria não encontrada com o ID: " + novoMeme.getCategoriaMemeId());
            }
            logger.info("Categoria validada com sucesso.");
        } catch (FeignException.NotFound e) {
            logger.error("Falha na validação: Categoria não encontrada com ID: {}", novoMeme.getCategoriaMemeId());
            throw new RuntimeException("Categoria não encontrada com o ID: " + novoMeme.getCategoriaMemeId());
        }

        logger.info("Validações concluídas. Salva meme...");

        novoMeme.setDataCadastro(new Date());
        Meme memeSalvo = memeRepository.save(novoMeme);

        logger.info("Meme salvo com sucesso. ID: {}", memeSalvo.getId());
        return memeSalvo;
    }
}
