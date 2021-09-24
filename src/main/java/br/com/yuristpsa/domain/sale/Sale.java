package br.com.yuristpsa.domain.sale;

import br.com.yuristpsa.base.BaseEntity;
import br.com.yuristpsa.domain.product.Product;
import br.com.yuristpsa.domain.salesman.Salesman;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Sale implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

//    @Column(name = "name")
    private Salesman salesman;

    @ManyToMany
    @JoinTable(name = "sale_item",
    joinColumns = {@JoinColumn(name = "sale_id")},
    inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private List<SaleItem> saleItens;

}
