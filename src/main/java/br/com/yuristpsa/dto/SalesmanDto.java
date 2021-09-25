package br.com.yuristpsa.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesmanDto implements Serializable {

    private Long id;
    private String name;
    private String registration;

}
