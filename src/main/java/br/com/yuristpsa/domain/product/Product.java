package br.com.yuristpsa.domain.product;

import br.com.yuristpsa.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements BaseEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_product_id"
    )
    @SequenceGenerator(
            name =  "sequence_product_id",
            sequenceName = "sequence_product"
    )
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

}
