package br.com.yuristpsa.dto;

import br.com.yuristpsa.domain.salesman.Salesman;
import br.com.yuristpsa.domain.salesman.SalesmanMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SaleTotalPriceBySalesmanDto implements Serializable {

    private SalesmanDto salesmanDto;
    private Double totalPrice;

    public SaleTotalPriceBySalesmanDto(Salesman salesman, Double totalPrice) {
        this.totalPrice = totalPrice;
        this.salesmanDto = new SalesmanMapper().toSalesmanDto(salesman);
    }
}
