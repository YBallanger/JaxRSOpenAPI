package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.PetDao;
import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.dao.generic.IGenericDao;
import fr.istic.taa.jaxrs.domain.Pet;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("pet")
@Produces({"application/json", "application/xml"})
public class PetResource {

  PetDao petDao = new PetDao();

  @GET
  @Path("/{petId}")
  public Pet getPetById(@PathParam("petId") Long petId)  {
        return petDao.findOne(1L);
  }

  @GET
  @Path("/")
  public Pet getPet(Long petId)  {
        return petDao.findOne(1L);
  }

  
  @POST
  @Consumes("application/json")
  public Response addPet(
      @Parameter(description = "Pet object that needs to be added to the store", required = true) Pet pet) {
    petDao.save(pet);
    return Response.ok().entity("SUCCESS").build();
  }
}