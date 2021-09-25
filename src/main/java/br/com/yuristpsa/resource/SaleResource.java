package br.com.yuristpsa.resource;

import br.com.yuristpsa.domain.sale.*;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sales")
public class SaleResource {

    private final SaleService saleService;

    public SaleResource(SaleService saleService) {
        this.saleService = saleService;
    }

    @POST
    public Response create(Sale sale) {
        Sale saleEntity = this.saleService.save(sale);
        return Response.status(Response.Status.OK).entity(saleEntity).build();
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
