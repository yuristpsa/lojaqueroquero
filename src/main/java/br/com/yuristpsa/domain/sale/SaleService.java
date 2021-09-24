package br.com.yuristpsa.domain.sale;

import br.com.yuristpsa.base.AbstractService;
import br.com.yuristpsa.domain.product.Product;
import br.com.yuristpsa.domain.product.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SaleService extends AbstractService<Product, ProductRepository> {

    @Inject
    public SaleService(ProductRepository repo) {
        super(repo);
    }

    public SaleService() {
        super();
    }
}
