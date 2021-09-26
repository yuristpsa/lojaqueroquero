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
public class SaleCountBySalesmanDto implements Serializable {

    private SalesmanDto salesmanDto;
    private long count;

    public SaleCountBySalesmanDto(SalesmanDto salesmanDto, long count) {
        this.salesmanDto = salesmanDto;
        this.count = count;
    }
}
