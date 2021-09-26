package br.com.yuristpsa.dto;

import br.com.yuristpsa.domain.product.Product;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleItemTotalAmountByProductDto {

    private Product product;
    private long count;

}
