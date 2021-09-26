package br.com.yuristpsa.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class SaleTotalPriceBySalesmanDto implements Serializable {

    private SalesmanDto salesmanDto;
    private Double totalPrice;

    public SaleTotalPriceBySalesmanDto(SalesmanDto salesmanDto, Double totalPrice) {
        this.totalPrice = totalPrice;
        this.salesmanDto = salesmanDto;
    }
}
