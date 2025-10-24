package meme_service.api_meme.repository;

import meme_service.api_meme.entities.Meme;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemeRepository extends MongoRepository<Meme, String> {
}
