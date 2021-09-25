package br.com.yuristpsa.domain.sale;

import br.com.yuristpsa.base.AbstractService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class SaleService extends AbstractService<Sale, SaleRepository> {

    private final EntityManager entityManager;

    @Inject
    public SaleService(SaleRepository repo, EntityManager entityManager) {
        super(repo);
        this.entityManager = entityManager;
    }

    public SaleService(EntityManager entityManager) {
        super();
        this.entityManager = entityManager;
    }

    private final String QUERY_SALE_COUNT_BY_SALESMAN = "SELECT new br.com.yuristpsa.domain.sale.SaleCountBySalesmanDto(count(se), se.salesman) " +
                                                        "FROM Sale se " +
                                                        "GROUP BY se.salesman " +
                                                        "ORDER BY count(se) DESC";

    public List<SaleCountBySalesmanDto> findSaleCountGroupBySalesmanOrderdByCountDesc() {
        TypedQuery<SaleCountBySalesmanDto> q = this.entityManager.createQuery(QUERY_SALE_COUNT_BY_SALESMAN, SaleCountBySalesmanDto.class);
        return q.getResultList();
    }

    private final String QUERY_SALE_ITEM_COUNT_BY_PRODUCT = "SELECT new br.com.yuristpsa.domain.sale.SaleItemCountByProductDto(si.product, sum(si.amount)) " +
            "FROM SaleItem si " +
            "GROUP BY si.product " +
            "ORDER BY sum(si.amount) DESC";

    public List<SaleItemCountByProductDto> findSaleItemCountGroupdByProductOrderByCountDesc() {
        TypedQuery<SaleItemCountByProductDto> q = this.entityManager.createQuery(QUERY_SALE_ITEM_COUNT_BY_PRODUCT, SaleItemCountByProductDto.class);
        return q.getResultList();
    }

}
