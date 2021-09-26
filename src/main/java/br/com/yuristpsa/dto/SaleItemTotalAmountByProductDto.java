package br.com.yuristpsa.dto;

import br.com.yuristpsa.domain.product.Product;
import br.com.yuristpsa.domain.product.ProductMapper;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
public class SaleItemTotalAmountByProductDto implements Serializable {

    private ProductDto productDto;
    private long count;

    public SaleItemTotalAmountByProductDto(Product product, long count) {
        this.productDto = new ProductMapper().toProductDto(product);
        this.count = count;
    }
}
