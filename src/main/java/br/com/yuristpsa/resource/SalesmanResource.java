package br.com.yuristpsa.resource;

import br.com.yuristpsa.domain.salesman.Salesman;
import br.com.yuristpsa.domain.salesman.SalesmanService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/salesmans")
public class SalesmanResource {

    private final SalesmanService salesmanService;

    public SalesmanResource(SalesmanService salesmanService) {
        this.salesmanService = salesmanService;
    }

    @POST
    public Response create(Salesman salesman) {
        Salesman salesmanEntity = this.salesmanService.save(salesman);
        return Response.status(Response.Status.OK).entity(salesman).build();
    }

/*    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Salesman salesman) {
//        Salesman salesmanUpdated = this.salesmanService.save(id, salesman);
//        return Response.status(Response.Status.OK).entity(salesmanUpdated).build();

        return null;
    }*/

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        this.salesmanService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    public List<Salesman> list() {
        return this.salesmanService.listAll();
    }

    @GET
    @Path("{registration}")
    public Salesman findByRegistration(@PathParam("registration") String registration) {
        return this.salesmanService.findByRegistration(registration);
    }

}
