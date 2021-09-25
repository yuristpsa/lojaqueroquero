package br.com.yuristpsa.resource;

import br.com.yuristpsa.domain.sale.Sale;
import br.com.yuristpsa.domain.sale.SaleRepository;
import br.com.yuristpsa.domain.sale.SaleService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/sales")
public class SaleResource {

    private final SaleService saleService;

    public SaleResource(SaleService saleService) {
        this.saleService = saleService;
    }

    @POST
    public Response create(Sale sale) {
        Sale saleEntity = this.saleService.save(sale);
//        return Response.status(Response.Status.OK).entity(saleEntity).build();
        return null;
    }

    @Inject
    SaleRepository saleRepository;

    @GET
    public Response list(Sale sale) {
        //saleRepository.findSalesCountBySalesman();
//        return Response.status(Response.Status.OK).entity(saleEntity).build();
        return null;
    }

}
