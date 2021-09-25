package br.com.yuristpsa.domain.sale;

import br.com.yuristpsa.base.AbstractService;
import br.com.yuristpsa.domain.product.Product;
import br.com.yuristpsa.domain.product.ProductService;
import br.com.yuristpsa.dto.SaleCountBySalesmanDto;
import br.com.yuristpsa.dto.SaleItemTotalAmountByProductDto;
import br.com.yuristpsa.dto.SaleTotalPriceBySalesmanDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class SaleService extends AbstractService<Sale, SaleRepository> {

    private final ProductService productService;

    @Inject
    public SaleService(SaleRepository repo, ProductService productService) {
        super(repo);
        this.productService = productService;
    }

    public SaleService(EntityManager entityManager, ProductService productService) {
        super();
        this.productService = productService;
    }

    @Transactional
    @Override
    public Sale save(Sale sale) {
        sale.setTotalPrice(calculateTotalPrice(sale));
        return super.save(sale);
    }

    private Double calculateTotalPrice(Sale sale) {
        return sale.getSaleItems().stream().mapToDouble(f -> {
            Product product = f.getProduct();
            if (Objects.isNull(f.getProduct().getPrice())) {
                product = this.productService.findById(f.getProduct().getId());
            }

            return f.getAmount() * product.getPrice();
        }).sum();
    }

    public List<SaleCountBySalesmanDto> findSaleCountGroupBySalesmanOrderdByCountDesc() {
        return repo.findSaleCountGroupBySalesmanOrderdByCountDesc();
    }

    public List<SaleTotalPriceBySalesmanDto> findSaleTotalPriceGroupBySalesmanOrderdByTotalPriceDesc() {
        return repo.findSaleTotalPriceGroupBySalesmanOrderdByTotalPriceDesc();
    }

    public List<SaleItemTotalAmountByProductDto> findSaleItemCountGroupByProductOrderByCountDesc() {
        return repo.findSaleItemCountGroupByProductOrderByCountDesc();
    }
}
