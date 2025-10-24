package user_service.api_user.service;

import org.springframework.stereotype.Service;
import user_service.api_user.entities.Usuario;
import user_service.api_user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<Usuario> getUsuarioById(String id) {
        return userRepository.findById(id);
    }

    public Usuario novoUsuario(Usuario usuario) {
        return userRepository.save(usuario);
    }

    public List<Usuario> listaTodosUsuarios() { return userRepository.findAll(); }
}
