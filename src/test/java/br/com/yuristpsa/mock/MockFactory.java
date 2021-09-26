package br.com.yuristpsa.mock;

import br.com.yuristpsa.domain.product.Product;
import br.com.yuristpsa.domain.salesman.Salesman;
import br.com.yuristpsa.dto.SaleCountBySalesmanDto;
import br.com.yuristpsa.dto.SaleItemTotalAmountByProductDto;
import br.com.yuristpsa.dto.SaleTotalPriceBySalesmanDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class MockFactory {

    public List<SaleItemTotalAmountByProductDto> createSaleItemTotalAmountByProductDtoList() {
        return Arrays.asList(
                new SaleItemTotalAmountByProductDto(
                        Product.builder()
                                .id(1L)
                                .name("Mouse Gamer Redragon Cobra")
                                .price(99.0)
                                .build(), 30),
                new SaleItemTotalAmountByProductDto(
                        Product.builder()
                                .id(2L)
                                .name("Aspirador de Pó Robô")
                                .price(1500.0)
                                .build(), 20),
                new SaleItemTotalAmountByProductDto(
                        Product.builder()
                                .id(1L)
                                .name("Memória Kingston Fury Beast, 8GB, 2666MHz, DDR4")
                                .price(289.0)
                                .build(), 10)
        );
    }

    public List<SaleCountBySalesmanDto> createSaleCountBySalesmanDtoList() {
        return Arrays.asList(
                new SaleCountBySalesmanDto(Salesman.builder()
                        .id(1L)
                        .name("Dária Quintais Varela")
                        .registration("DQV")
                        .build(), 3000),
                new SaleCountBySalesmanDto(Salesman.builder()
                        .id(2L)
                        .name("Eder Muniz Fontoura")
                        .registration("EMF")
                        .build(), 1000),
                new SaleCountBySalesmanDto(Salesman.builder()
                        .id(3L)
                        .name("Amadeu Noite Perdigão")
                        .registration("ANP")
                        .build(), 500)
        );
    }

    public List<SaleTotalPriceBySalesmanDto> createSaleTotalPriceBySalesmanDtoList() {
        return Arrays.asList(
                new SaleTotalPriceBySalesmanDto(
                        Salesman.builder()
                                .id(1L)
                                .name("Dária Quintais Varela")
                                .registration("DQV")
                                .build(), 3000.0),
                new SaleTotalPriceBySalesmanDto(Salesman.builder()
                        .id(2L)
                        .name("Eder Muniz Fontoura")
                        .registration("EMF")
                        .build(), 2000.0),
                new SaleTotalPriceBySalesmanDto(
                        Salesman.builder()
                                .id(3L)
                                .name("Amadeu Noite Perdigão")
                                .registration("ANP")
                                .build(), 500.0)
        );
    }
}
