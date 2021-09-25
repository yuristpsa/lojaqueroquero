package br.com.yuristpsa.domain.sale;

import br.com.yuristpsa.domain.salesman.Salesman;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleCountBySalesmanDto {

    private Salesman salesman;
    private long count;

    public SaleCountBySalesmanDto(long count, Salesman salesman) {
        this.count = count;
        this.salesman = salesman;
    }
}
