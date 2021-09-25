package br.com.yuristpsa.domain.sale;

import br.com.yuristpsa.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleItemCountByProductDto {

    private Product product;
    private long count;

}
