package br.com.yuristpsa.dto;

import br.com.yuristpsa.domain.salesman.Salesman;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaleCountBySalesmanDto {

    private Salesman salesman;
    private long count;

    public SaleCountBySalesmanDto(Salesman salesman, long count) {
        this.salesman = salesman;
        this.count = count;
    }
}
