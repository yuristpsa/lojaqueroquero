package br.com.yuristpsa.domain.sale;

import br.com.yuristpsa.base.BaseEntity;
import br.com.yuristpsa.domain.salesman.Salesman;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
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
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "sale")
    @TableGenerator(name="sale", table="sequence", schema="public")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "salesman_id", nullable = false)
    private Salesman salesman;

    @Column(name = "total_price")
    private Double totalPrice;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleItem> saleItems = new ArrayList<>();

    public static SaleBuilder builder() {
        return new CustomSaleBuilder();
    }

    public void setSaleItems(List<SaleItem> saleItems) {
        saleItems.forEach(f -> f.setSale(this));
        this.saleItems = saleItems;
    }

    private Double calculateTotalPrice(List<SaleItem> saleItems) {

/*        return this.userList
                .parallelStream()
                .reduce(
                        0, (partialAgeResult, user) -> partialAgeResult + user.getAge(), Integer::sum);*/



        return null;
    }

    private static class CustomSaleBuilder extends SaleBuilder {

        @Override
        public Sale build() {
            Sale sale = super.build();
            sale.setSaleItems(sale.getSaleItems());
            return sale;
        }
    }
}
