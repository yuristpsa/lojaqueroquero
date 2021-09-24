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
public class SaleItem implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "product")
    private Product product;

    @Column(name = "sale")
    private Sale sale;

    @Column(name = "price")
    private Integer amount;

    @ManyToMany
    @JoinTable(name = "sale_product",
    joinColumns = {@JoinColumn(name = "sale_id")})
    private List<Product> products;

}
