package br.com.yuristpsa.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleItemDto implements Serializable {

    private Long id;
    private ProductDto product;
    private Integer amount;

}