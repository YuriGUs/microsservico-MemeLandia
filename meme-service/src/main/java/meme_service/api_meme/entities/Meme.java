package meme_service.api_meme.entities;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "memes")
public class Meme {

    @Id
    @NotNull
    private String id;

    @NotNull
    private String nome;

    @NotNull
    private String descricao;

    private Date dataCadastro;

    @NotNull
    private String categoriaMemeId;

    @NotNull
    private String usuarioId;
}
