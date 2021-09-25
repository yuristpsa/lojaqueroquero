package br.com.yuristpsa.resource;

import br.com.yuristpsa.domain.sale.Sale;
import br.com.yuristpsa.dto.SaleCountBySalesmanDto;
import br.com.yuristpsa.dto.SaleItemTotalAmountByProductDto;
import br.com.yuristpsa.domain.sale.SaleMapper;
import br.com.yuristpsa.domain.sale.SaleService;
import br.com.yuristpsa.dto.SaleDto;
import br.com.yuristpsa.dto.SaleTotalPriceBySalesmanDto;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sales")
public class SaleResource {

    private final SaleService saleService;
    private final SaleMapper saleMapper;

    public SaleResource(SaleService saleService, SaleMapper saleMapper) {
        this.saleService = saleService;
        this.saleMapper = saleMapper;
    }

    @POST
    public Response create(SaleDto saleDto) {
        Sale saleEntity = this.saleService.save(this.saleMapper.toSaleEntity(saleDto));
        return Response.status(Response.Status.OK).entity(this.saleMapper.toSaleDto(saleEntity)).build();
    }

    @GET
    @Path("/reports/best-selling-items")
    public List<SaleItemTotalAmountByProductDto> getBestSellingItems() {
        return this.saleService.findSaleItemCountGroupByProductOrderByCountDesc();
    }

    @GET
    @Path("/reports/best-sellers-by-sales-quantity")
    public List<SaleCountBySalesmanDto> getBestSellersBySalesQuantity() {
        return this.saleService.findSaleCountGroupBySalesmanOrderdByCountDesc();
    }

    @GET
    @Path("/reports/best-sellers-by-value-sold")
    public List<SaleTotalPriceBySalesmanDto> getBestSellersByValueSold() {
        return this.saleService.findSaleTotalPriceGroupBySalesmanOrderdByTotalPriceDesc();
    }
}
