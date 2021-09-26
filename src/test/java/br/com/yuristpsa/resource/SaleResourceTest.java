package br.com.yuristpsa.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class SaleResourceTest {

//    @Inject
//    SaleService saleService;
//
//    @InjectMocks
//    SaleRepository saleRepository;

//    @BeforeEach
//    void setUp() {
//        when(saleRepository.findSaleItemCountGroupByProductOrderByCountDesc())
//                .thenReturn(Arrays.asList(
//                        SaleItemTotalAmountByProductDto.builder()
//                                .count(1)
//                                .build()
//                ));
//
///*        when
//        when(bookRepository.findBy("Frank Herbert"))
//                .thenReturn(Arrays.stream(new Book[] {
//                        new Book("Dune", "Frank Herbert"),
//                        new Book("Children of Dune", "Frank Herbert")}));*/
//    }


    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/sales/reports/best-selling-items")
                .then()
                .statusCode(200)
                .body(is("hello"));
    }

}
