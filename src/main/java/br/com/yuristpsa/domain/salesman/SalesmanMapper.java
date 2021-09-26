package br.com.yuristpsa.domain.salesman;

import br.com.yuristpsa.dto.SalesmanDto;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SalesmanMapper {

    public SalesmanDto toSalesmanDto(Salesman salesman) {
        return SalesmanDto.builder()
                .id(salesman.getId())
                .name(salesman.getName())
                .registration(salesman.getRegistration())
                .build();
    }

    public Salesman toSalesmanEntity(SalesmanDto salesmanDto) {
        return Salesman.builder()
                .id(salesmanDto.getId())
                .name(salesmanDto.getName())
                .registration(salesmanDto.getRegistration())
                .build();
    }

    public Salesman toSalesmanEntity(Salesman salesmanEntity, SalesmanDto salesmanDto) {
        salesmanEntity.setName(salesmanDto.getName());
        salesmanEntity.setRegistration(salesmanDto.getRegistration());
        return salesmanEntity;
    }

}
