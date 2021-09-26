package br.com.yuristpsa.dto;

import br.com.yuristpsa.domain.product.Product;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleItemTotalAmountByProductDto implements Serializable {

    private Product product;
    private long count;

}
