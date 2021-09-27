package br.com.yuristpsa.domain.sale;

import br.com.yuristpsa.domain.product.Product;
import br.com.yuristpsa.domain.product.ProductService;
import br.com.yuristpsa.domain.salesman.Salesman;
import br.com.yuristpsa.domain.salesman.SalesmanService;
import br.com.yuristpsa.dto.SaleCountBySalesmanDto;
import br.com.yuristpsa.dto.SaleItemTotalAmountByProductDto;
import br.com.yuristpsa.dto.SaleTotalPriceBySalesmanDto;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class SaleServiceTest {

    @Inject
    SaleService saleService;

    @Inject
    SalesmanService salesmanService;

    @Inject
    ProductService productService;

    @Test
    @Order(1)
    public void testFindSaleCountGroupBySalesmanOrderdByCountDesc() {
        List<SaleCountBySalesmanDto> salesCountBySalesman = saleService.findSaleCountGroupBySalesmanOrderdByCountDesc();

        SaleCountBySalesmanDto saleCount = salesCountBySalesman.get(0);
        Assertions.assertEquals(3, saleCount.getCount());
        Assertions.assertEquals("Dária Quintais Varela", saleCount.getSalesmanDto().getName());

        saleCount = salesCountBySalesman.get(1);
        Assertions.assertEquals(2, saleCount.getCount());
        Assertions.assertEquals("Eder Muniz Fontoura", saleCount.getSalesmanDto().getName());

        saleCount = salesCountBySalesman.get(2);
        Assertions.assertEquals(1, saleCount.getCount());
        Assertions.assertEquals("Amadeu Noite Perdigão", saleCount.getSalesmanDto().getName());
    }

    @Test
    @Order(2)
    public void testFindSaleTotalPriceGroupBySalesmanOrderdByTotalPriceDesc() {
        List<SaleTotalPriceBySalesmanDto> salesTotalPriceBySalesman = saleService.findSaleTotalPriceGroupBySalesmanOrderdByTotalPriceDesc();

        SaleTotalPriceBySalesmanDto saleCount = salesTotalPriceBySalesman.get(0);
        Assertions.assertEquals(113940.0, saleCount.getTotalPrice());
        Assertions.assertEquals("Dária Quintais Varela", saleCount.getSalesmanDto().getName());

        saleCount = salesTotalPriceBySalesman.get(1);
        Assertions.assertEquals(50405.0, saleCount.getTotalPrice());
        Assertions.assertEquals("Eder Muniz Fontoura", saleCount.getSalesmanDto().getName());

        saleCount = salesTotalPriceBySalesman.get(2);
        Assertions.assertEquals(7500.0, saleCount.getTotalPrice());
        Assertions.assertEquals("Amadeu Noite Perdigão", saleCount.getSalesmanDto().getName());
    }

    @Test
    @Order(3)
    public void testFindSaleItemCountGroupByProductOrderByCountDesc() {
        List<SaleItemTotalAmountByProductDto> salesItemTotalAmountByProduct = saleService.findSaleItemCountGroupByProductOrderByCountDesc();

        SaleItemTotalAmountByProductDto saleCount = salesItemTotalAmountByProduct.get(0);
        Assertions.assertEquals(270, saleCount.getCount());
        Assertions.assertEquals("Mouse Gamer Redragon Cobra", saleCount.getProductDto().getName());

        saleCount = salesItemTotalAmountByProduct.get(1);
        Assertions.assertEquals(90, saleCount.getCount());
        Assertions.assertEquals("Aspirador de Pó Robô", saleCount.getProductDto().getName());

        saleCount = salesItemTotalAmountByProduct.get(2);
        Assertions.assertEquals(35, saleCount.getCount());
        Assertions.assertEquals("Memória Kingston Fury Beast, 8GB, 2666MHz, DDR4", saleCount.getProductDto().getName());
    }

    @Test
    @Order(4)
    public void testSaveSale() {
        Salesman salesman = this.salesmanService.findById(1L);
        Product product = this.productService.findById(1L);

        Sale sale = Sale.builder()
                .salesman(salesman)
                .saleItems(List.of(
                        SaleItem.builder()
                                .product(product)
                                .amount(5)
                                .build()
                ))
                .build();

        sale = this.saleService.save(sale);
        Assertions.assertNotNull(sale.getId());
        Assertions.assertEquals(salesman, sale.getSalesman());
        Assertions.assertEquals(5, sale.getSaleItems().get(0).getAmount());
        Assertions.assertEquals(product, sale.getSaleItems().get(0).getProduct());
        Assertions.assertEquals(product.getPrice() * sale.getSaleItems().get(0).getAmount(), sale.getTotalPrice());
    }

}
