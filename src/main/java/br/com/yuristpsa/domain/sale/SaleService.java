package br.com.yuristpsa.domain.sale;

import br.com.yuristpsa.base.AbstractService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SaleService extends AbstractService<Sale, SaleRepository> {

    @Inject
    public SaleService(SaleRepository repo) {
        super(repo);
    }

    public SaleService() {
        super();
    }

}
