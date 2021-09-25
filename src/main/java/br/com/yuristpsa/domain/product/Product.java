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
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "product")
    @TableGenerator(name="product", table="sequence", schema="public")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

}
