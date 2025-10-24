package user_service.api_user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import user_service.api_user.entities.Usuario;

public interface UserRepository extends MongoRepository<Usuario, String> {
}
