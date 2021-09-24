package br.com.yuristpsa.domain.product;

import br.com.yuristpsa.base.AbstractService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ProductService extends AbstractService<Product, ProductRepository> {

    @Inject
    public ProductService(ProductRepository repo) {
        super(repo);
    }

    public ProductService() {
        super();
    }
}
