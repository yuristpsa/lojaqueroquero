package br.com.yuristpsa.domain.sale;

import br.com.yuristpsa.dto.SaleCountBySalesmanDto;
import br.com.yuristpsa.dto.SaleItemTotalAmountByProductDto;
import br.com.yuristpsa.dto.SaleTotalPriceBySalesmanDto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class SaleRepository implements PanacheRepository<Sale> {

    private final String QUERY_SALE_COUNT_BY_SALESMAN = "SELECT new br.com.yuristpsa.dto.SaleCountBySalesmanDto(se.salesman, count(se)) " +
            "FROM Sale se " +
            "GROUP BY se.salesman " +
            "ORDER BY count(se) DESC";

    private final String QUERY_SALE_TOTAL_PRICE_BY_SALESMAN = "SELECT new br.com.yuristpsa.dto.SaleTotalPriceBySalesmanDto(se.salesman, sum(se.totalPrice)) " +
            "FROM Sale se " +
            "GROUP BY se.salesman " +
            "ORDER BY sum(se.totalPrice) DESC";

    private final String QUERY_SALE_ITEM_TOTAL_AMOUNT_BY_PRODUCT = "SELECT new br.com.yuristpsa.dto.SaleItemTotalAmountByProductDto(si.product, sum(si.amount)) " +
            "FROM SaleItem si " +
            "GROUP BY si.product " +
            "ORDER BY sum(si.amount) DESC";

    public List<SaleCountBySalesmanDto> findSaleCountGroupBySalesmanOrderdByCountDesc() {
        TypedQuery<SaleCountBySalesmanDto> query = getEntityManager().createQuery(QUERY_SALE_COUNT_BY_SALESMAN, SaleCountBySalesmanDto.class);
        return query.getResultList();
    }

    public List<SaleTotalPriceBySalesmanDto> findSaleTotalPriceGroupBySalesmanOrderdByTotalPriceDesc() {
        TypedQuery<SaleTotalPriceBySalesmanDto> query = getEntityManager().createQuery(QUERY_SALE_TOTAL_PRICE_BY_SALESMAN, SaleTotalPriceBySalesmanDto.class);
        return query.getResultList();
    }

    public List<SaleItemTotalAmountByProductDto> findSaleItemCountGroupByProductOrderByCountDesc() {
        TypedQuery<SaleItemTotalAmountByProductDto> query = getEntityManager().createQuery(QUERY_SALE_ITEM_TOTAL_AMOUNT_BY_PRODUCT, SaleItemTotalAmountByProductDto.class);
        return query.getResultList();
    }
}
