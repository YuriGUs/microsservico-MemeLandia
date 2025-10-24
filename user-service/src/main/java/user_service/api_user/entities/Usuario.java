package user_service.api_user.entities;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "usuarios")
public class Usuario {

    @Id
    private String id;

    @NotNull
    private String nome;

    @NotNull
    private String email;

    @NotNull
    private Date dataCadastro;
}
