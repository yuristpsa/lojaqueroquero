package br.com.yuristpsa.domain.product;

import br.com.yuristpsa.dto.ProductDto;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductMapper {

    public ProductDto toProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    public Product toProductEntity(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .build();
    }

    public Product toProductEntity(Product productEntity, ProductDto productDto) {
        productEntity.setPrice(productDto.getPrice());
        productEntity.setName(productDto.getName());
        return productEntity;
    }
}
