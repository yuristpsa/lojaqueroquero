package br.com.yuristpsa.domain.sale;

import br.com.yuristpsa.base.BaseEntity;
import br.com.yuristpsa.domain.product.Product;
import br.com.yuristpsa.domain.salesman.Salesman;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sale implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "salesman_id", nullable = false)
    private Salesman salesman;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleItem> saleItens = new ArrayList<>();

    public void setSaleItens(List<SaleItem> saleItens) {
        saleItens.forEach(f -> f.setSale(this));
        this.saleItens = saleItens;
    }

    public void addSaleItem(SaleItem saleItem) {
        if (Objects.isNull(saleItens))
            saleItens = new ArrayList<>();

        saleItens.add(saleItem);
        saleItem.setSale(this);
    }
}
