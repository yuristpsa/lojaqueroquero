package br.com.yuristpsa.base;

import br.com.yuristpsa.base.BaseEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.transaction.Transactional;
import java.util.List;

public class AbstractService<E extends BaseEntity, R extends PanacheRepository<E>> {

    protected R repo;

    public AbstractService(R repo) {
        this.repo = repo;
    }

    public AbstractService() {

    }

    @Transactional
    public E save(E entity) {
        repo.persist(entity);
        return entity;
    }

    @Transactional
    public void delete(Long id) {
        E entity = repo.findById(id);
        repo.delete(entity);
    }

    public List<E> listAll() {
        return this.repo.listAll();
    }
}
