package br.com.yuristpsa.resource;

import br.com.yuristpsa.domain.sale.Sale;
import br.com.yuristpsa.domain.sale.SaleItemCountByProductDto;
import br.com.yuristpsa.domain.sale.SaleMapper;
import br.com.yuristpsa.domain.sale.SaleService;
import br.com.yuristpsa.dto.SaleDto;

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









/*    @GET
    public List<SaleCountBySalesmanDto> list() {
        return this.saleService.findSaleCountBySalesmanDto();
    }*/

    @GET
    public List<SaleItemCountByProductDto> list() {
        return this.saleService.findSaleItemCountGroupdByProductOrderByCountDesc();
    }

}
