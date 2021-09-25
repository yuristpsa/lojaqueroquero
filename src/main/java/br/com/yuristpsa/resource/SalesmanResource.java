package br.com.yuristpsa.resource;

import br.com.yuristpsa.domain.salesman.Salesman;
import br.com.yuristpsa.domain.salesman.SalesmanMapper;
import br.com.yuristpsa.domain.salesman.SalesmanService;
import br.com.yuristpsa.dto.SalesmanDto;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/salesmans")
public class SalesmanResource {

    private final SalesmanService salesmanService;
    private final SalesmanMapper salesmanMapper;

    public SalesmanResource(SalesmanService salesmanService,
                            SalesmanMapper salesmanMapper) {
        this.salesmanService = salesmanService;
        this.salesmanMapper = salesmanMapper;
    }

    @POST
    public Response create(SalesmanDto salesmanDto) {
        Salesman salesmanEntity = this.salesmanService.save(this.salesmanMapper.toSalesmanEntity(salesmanDto));
        return Response.status(Response.Status.OK).entity(this.salesmanMapper.toSalesmanDto(salesmanEntity)).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, SalesmanDto salesmanDto) {
        if (!salesmanService.exists(id)) {
            return Response.status(Response.Status.NOT_FOUND).entity("Registro não encontrado").build();
        }

        Salesman salesmanEntity = this.salesmanMapper.toSalesmanEntity(salesmanDto);
        salesmanEntity.setId(id);

        return Response.status(Response.Status.OK).entity(this.salesmanMapper.toSalesmanDto(salesmanService.save(salesmanEntity))).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        this.salesmanService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    public List<SalesmanDto> list() {
        return this.salesmanService.listAll()
                .stream()
                .map(this.salesmanMapper::toSalesmanDto)
                .collect(Collectors.toList());
    }

    @GET
    @Path("{registration}")
    public Salesman findByRegistration(@PathParam("registration") String registration) {
        return this.salesmanService.findByRegistration(registration);
    }

}
