package br.com.yuristpsa.dto;

import br.com.yuristpsa.domain.salesman.Salesman;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaleTotalPriceBySalesmanDto {

    private Salesman salesman;
    private Double totalPrice;

    public SaleTotalPriceBySalesmanDto(Salesman salesman, Double totalPrice) {
        this.totalPrice = totalPrice;
        this.salesman = salesman;
    }
}
