package meme_service.api_meme.controller;

import meme_service.api_meme.entities.Meme;
import meme_service.api_meme.service.MemeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meme")
public class MemeController {

    private final MemeService memeService;

    public MemeController(MemeService memeService) {
        this.memeService = memeService;
    }

    @GetMapping
    public List<Meme> listaTodosMemes() { return memeService.listaTodosMemes(); }

    @PostMapping
    public Meme criaMeme(@RequestBody Meme meme) {
        return memeService.criarMeme(meme);
    }
}
