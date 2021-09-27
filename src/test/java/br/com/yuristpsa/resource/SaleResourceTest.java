package br.com.yuristpsa.resource;

import br.com.yuristpsa.domain.sale.SaleService;
import br.com.yuristpsa.mock.MockFactory;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@QuarkusTest
public class SaleResourceTest {

    @InjectMock
    SaleService saleService;

    @Inject
    MockFactory mockFactory;

    @BeforeEach
    void setUp() {
        when(saleService.findSaleItemCountGroupByProductOrderByCountDesc()).thenReturn(mockFactory.createSaleItemTotalAmountByProductDtoList());
        when(saleService.findSaleCountGroupBySalesmanOrderdByCountDesc()).thenReturn(mockFactory.createSaleCountBySalesmanDtoList());
        when(saleService.findSaleTotalPriceGroupBySalesmanOrderdByTotalPriceDesc()).thenReturn(mockFactory.createSaleTotalPriceBySalesmanDtoList());
        when(saleService.save(any())).thenReturn(mockFactory.createSale());
    }

    @Test
    public void whenCallBestSellingItemsThenReturnListOfBestSellingItems() {
        given()
                .when().get("/sales/reports/best-selling-items")
                .then()
                .statusCode(200)
                .body(is("[{\"count\":30,\"productDto\":{\"id\":1,\"name\":\"Mouse Gamer Redragon Cobra\",\"price\":99.0}}," +
                        "{\"count\":20,\"productDto\":{\"id\":2,\"name\":\"Aspirador de Pó Robô\",\"price\":1500.0}}," +
                        "{\"count\":10,\"productDto\":{\"id\":1,\"name\":\"Memória Kingston Fury Beast, 8GB, 2666MHz, DDR4\",\"price\":289.0}}]"));
    }

    @Test
    public void whenCallBestSellersBySalesQuantityThenReturnListOfBestSellersBySalesQuantity() {
        given()
                .when().get("/sales/reports/best-sellers-by-sales-quantity")
                .then()
                .statusCode(200)
                .body(is("[{\"count\":3000,\"salesmanDto\":{\"id\":1,\"name\":\"Dária Quintais Varela\",\"registration\":\"DQV\"}}," +
                        "{\"count\":1000,\"salesmanDto\":{\"id\":2,\"name\":\"Eder Muniz Fontoura\",\"registration\":\"EMF\"}}," +
                        "{\"count\":500,\"salesmanDto\":{\"id\":3,\"name\":\"Amadeu Noite Perdigão\",\"registration\":\"ANP\"}}]"));
    }

    @Test
    public void whenCallBestSellersByValueSoldThenReturnListOfBestSellersBValueSold() {
        given()
                .when().get("/sales/reports/best-sellers-by-value-sold")
                .then()
                .statusCode(200)
                .body(is("[{\"salesmanDto\":{\"id\":1,\"name\":\"Dária Quintais Varela\",\"registration\":\"DQV\"},\"totalPrice\":3000.0}," +
                        "{\"salesmanDto\":{\"id\":2,\"name\":\"Eder Muniz Fontoura\",\"registration\":\"EMF\"},\"totalPrice\":2000.0}," +
                        "{\"salesmanDto\":{\"id\":3,\"name\":\"Amadeu Noite Perdigão\",\"registration\":\"ANP\"},\"totalPrice\":500.0}]"));
    }
}
