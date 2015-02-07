package com.geiswinkler.yasl.rest;

import com.geiswinkler.yasl.entities.ShoppingList;
import com.geiswinkler.yasl.service.ShoppingListService;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * RESTful Webservice for resource ShoppingList
 *
 * Created by mike on 05.02.2015.
 */
@Path("/list")
@RequestScoped
@Transactional
@Stateless
public class ShoppingListResource {
	@Inject
    ShoppingListService shoppingListService;

    @GET
    @Path("/")
    @Produces("application/json")
    public List<ShoppingList> getShoppingLists() {
        return shoppingListService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public ShoppingList getShoppingList(@PathParam("id") Long id) throws Exception{
        return shoppingListService.getById(id);
    }

    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createShoppingList(ShoppingList shoppingList) {
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateShoppingList(@PathParam("id") Long id, ShoppingList shoppingList) {
        return Response.status(Response.Status.CREATED).build();
    }
}