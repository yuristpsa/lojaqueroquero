package br.com.yuristpsa.dto;

import br.com.yuristpsa.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleItemTotalAmountByProductDto {

    private Product product;
    private long count;

}
