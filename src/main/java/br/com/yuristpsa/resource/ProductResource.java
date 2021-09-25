package br.com.yuristpsa.resource;

import br.com.yuristpsa.domain.product.Product;
import br.com.yuristpsa.domain.product.ProductMapper;
import br.com.yuristpsa.domain.product.ProductService;
import br.com.yuristpsa.dto.ProductDto;
import com.arjuna.ats.jta.exceptions.NotImplementedException;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/products")
public class ProductResource {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductResource(ProductService productService,
                           ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @POST
    public Response create(ProductDto productDto) {
        Product productEntity = this.productService.save(this.productMapper.toProductEntity(productDto));
        return Response.status(Response.Status.OK).entity(this.productMapper.toProductDto(productEntity)).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, ProductDto productDto) {
        if (!productService.exists(id)) {
            return Response.status(Response.Status.NOT_FOUND).entity("Registro não encontrado").build();
        }

        Product productEntity = this.productMapper.toProductEntity(productDto);
        productEntity.setId(id);

        return Response.status(Response.Status.OK).entity(this.productMapper.toProductDto(productService.save(productEntity))).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        this.productService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    public List<ProductDto> list() {
        return this.productService.listAll()
                .stream()
                .map(this.productMapper::toProductDto)
                .collect(Collectors.toList());
    }
}
