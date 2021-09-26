package br.com.yuristpsa.dto;

import br.com.yuristpsa.domain.salesman.Salesman;
import br.com.yuristpsa.domain.salesman.SalesmanMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SaleCountBySalesmanDto implements Serializable {

    private SalesmanDto salesmanDto;
    private long count;

    public SaleCountBySalesmanDto(Salesman salesman, long count) {
        this.salesmanDto = new SalesmanMapper().toSalesmanDto(salesman);
        this.count = count;
    }
}
