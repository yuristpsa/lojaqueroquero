package br.com.yuristpsa.base;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import lombok.NoArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;

@NoArgsConstructor
public class AbstractService<E extends BaseEntity, R extends PanacheRepository<E>> {

    protected R repo;

    public AbstractService(R repo) {
        this.repo = repo;
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

    public boolean exists(Long id) {
        return repo.findByIdOptional(id).isPresent();
    }

    public E findById(Long id) {
        return repo.findById(id);
    }

    public List<E> listAll() {
        return this.repo.listAll();
    }
}
