package ProgramRh.domain.Curriculo;
package ProgramRh.domain.curriculo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter''
@Setter
public class Curriculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    @Column(columnDefinition = "TEXT")
    private String experiencia;

    private String telefone;
    private String endereco;

    private String fileName;  // Nome do arquivo do currículo
    private String contentType;  // Tipo de conteúdo (ex: "application/pdf")
    private byte[] conteudo;  // O arquivo binário

    private LocalDate dataCriacao = LocalDate.now();
}
