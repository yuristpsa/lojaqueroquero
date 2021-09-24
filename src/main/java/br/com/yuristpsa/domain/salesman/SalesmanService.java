package br.com.yuristpsa.domain.salesman;

import br.com.yuristpsa.base.AbstractService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SalesmanService extends AbstractService<Salesman, SalesmanRepository> {

    @Inject
    public SalesmanService(SalesmanRepository repo) {
        super(repo);
    }

    public SalesmanService() {
        super();
    }

    public Salesman findByRegistration(String registration) {
        return repo.find("registration", registration).firstResult();
    }
}
