package br.com.yuristpsa.resource;

import br.com.yuristpsa.domain.product.Product;
import br.com.yuristpsa.domain.product.ProductService;
import br.com.yuristpsa.domain.salesman.Salesman;
import br.com.yuristpsa.domain.salesman.SalesmanService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/products")
public class ProductResource {

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @POST
    public Response create(Product product) {
        Product productEntity = this.productService.save(product);
        return Response.status(Response.Status.OK).entity(product).build();
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
        this.productService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    public List<Product> list() {
        return this.productService.listAll();
    }

}
