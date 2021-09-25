package br.com.yuristpsa.domain.sale;

import br.com.yuristpsa.domain.product.ProductMapper;
import br.com.yuristpsa.domain.salesman.SalesmanMapper;
import br.com.yuristpsa.dto.SaleDto;
import br.com.yuristpsa.dto.SaleItemDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class SaleMapper {

    private final SalesmanMapper salesmanMapper;
    private final ProductMapper productMapper;

    @Inject
    public SaleMapper(SalesmanMapper salesmanMapper,
                      ProductMapper productMapper) {
        this.salesmanMapper = salesmanMapper;
        this.productMapper = productMapper;
    }

    public SaleDto toSaleDto(Sale sale) {
        return SaleDto.builder()
                .id(sale.getId())
                .salesman(this.salesmanMapper.toSalesmanDto(sale.getSalesman()))
                .saleItems(toSaleItemsDto(sale.getSaleItems()))
                .build();
    }

    private List<SaleItemDto> toSaleItemsDto(List<SaleItem> saleItems) {
        return saleItems.stream()
                .map(f -> SaleItemDto.builder()
                        .id(f.getId())
                        .product(this.productMapper.toProductDto(f.getProduct()))
                        .amount(f.getAmount())
                        .build()).collect(Collectors.toList());

    }

    public Sale toSaleEntity(SaleDto saleDto) {
        return Sale.builder()
                .id(saleDto.getId())
                .salesman(this.salesmanMapper.toSalesmanEntity(saleDto.getSalesman()))
                .saleItems(toSaleItemsEntity(saleDto.getSaleItems()))
                .build();
    }

    private List<SaleItem> toSaleItemsEntity(List<SaleItemDto> saleItemsDto) {
        return saleItemsDto.stream()
                .map(f -> SaleItem.builder()
                        .id(f.getId())
                        .product(this.productMapper.toProductEntity(f.getProduct()))
                        .amount(f.getAmount())
                        .build()).collect(Collectors.toList());

    }
}
