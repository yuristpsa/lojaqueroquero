package br.com.yuristpsa.mock;

import br.com.yuristpsa.domain.product.Product;
import br.com.yuristpsa.dto.SaleCountBySalesmanDto;
import br.com.yuristpsa.dto.SaleItemTotalAmountByProductDto;
import br.com.yuristpsa.dto.SaleTotalPriceBySalesmanDto;
import br.com.yuristpsa.dto.SalesmanDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class MockFactory {

    public List<SaleItemTotalAmountByProductDto> createSaleItemTotalAmountByProductDtoList() {
        return Arrays.asList(
                SaleItemTotalAmountByProductDto.builder()
                        .product(Product.builder()
                                .id(1L)
                                .name("Mouse Gamer Redragon Cobra")
                                .price(99.0)
                                .build())
                        .count(30)
                        .build(),
                SaleItemTotalAmountByProductDto.builder()
                        .product(Product.builder()
                                .id(2L)
                                .name("Aspirador de Pó Robô")
                                .price(1500.0)
                                .build())
                        .count(20)
                        .build(),
                SaleItemTotalAmountByProductDto.builder()
                        .product(Product.builder()
                                .id(1L)
                                .name("Memória Kingston Fury Beast, 8GB, 2666MHz, DDR4")
                                .price(289.0)
                                .build())
                        .count(10)
                        .build()
        );
    }

    public List<SaleCountBySalesmanDto> createSaleCountBySalesmanDtoList() {
        return Arrays.asList(
                SaleCountBySalesmanDto.builder()
                        .salesmanDto(SalesmanDto.builder()
                                .id(1L)
                                .name("Dária Quintais Varela")
                                .registration("DQV")
                                .build())
                        .count(3000)
                        .build(),
                SaleCountBySalesmanDto.builder()
                        .salesmanDto(SalesmanDto.builder()
                                .id(2L)
                                .name("Eder Muniz Fontoura")
                                .registration("EMF")
                                .build())
                        .count(1000)
                        .build(),
                SaleCountBySalesmanDto.builder()
                        .salesmanDto(SalesmanDto.builder()
                                .id(3L)
                                .name("Amadeu Noite Perdigão")
                                .registration("ANP")
                                .build())
                        .count(500)
                        .build()
        );
    }

    public List<SaleTotalPriceBySalesmanDto> createSaleTotalPriceBySalesmanDtoList() {
        return Arrays.asList(
                SaleTotalPriceBySalesmanDto.builder()
                        .salesmanDto(SalesmanDto.builder()
                                .id(1L)
                                .name("Dária Quintais Varela")
                                .registration("DQV")
                                .build())
                        .totalPrice(3000.0)
                        .build(),
                SaleTotalPriceBySalesmanDto.builder()
                        .salesmanDto(SalesmanDto.builder()
                                .id(2L)
                                .name("Eder Muniz Fontoura")
                                .registration("EMF")
                                .build())
                        .totalPrice(2000.0)
                        .build(),
                SaleTotalPriceBySalesmanDto.builder()
                        .salesmanDto(SalesmanDto.builder()
                                .id(3L)
                                .name("Amadeu Noite Perdigão")
                                .registration("ANP")
                                .build())
                        .totalPrice(500.0)
                        .build()
        );
    }
}
