package br.com.yuristpsa.domain.sale;

import br.com.yuristpsa.base.BaseEntity;
import br.com.yuristpsa.domain.product.Product;
import br.com.yuristpsa.domain.salesman.Salesman;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sale_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleItem implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "sale_item")
    @TableGenerator(name="sale_item", table="sequence", schema="public")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "amount")
    private Integer amount;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sale sale;

}