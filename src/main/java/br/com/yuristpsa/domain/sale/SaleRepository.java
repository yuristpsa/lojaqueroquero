package br.com.yuristpsa.domain.sale;

import br.com.yuristpsa.domain.product.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SaleRepository implements PanacheRepository<Product> {

}
