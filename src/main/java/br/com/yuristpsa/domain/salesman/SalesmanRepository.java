package br.com.yuristpsa.domain.salesman;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SalesmanRepository implements PanacheRepository<Salesman> {



}
