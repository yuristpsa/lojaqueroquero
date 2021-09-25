package br.com.yuristpsa.dto;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleDto implements Serializable {

    private Long id;
    private SalesmanDto salesman;
    private List<SaleItemDto> saleItems = new ArrayList<>();
    private Double totalPrice;

}
