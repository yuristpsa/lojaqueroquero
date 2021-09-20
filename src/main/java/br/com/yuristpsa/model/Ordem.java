package br.com.yuristpsa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double preco;

    private String tipo;

    private LocalDate data;

    private String status;

    @Column(name = "user_id")
    private Long userId;

}
