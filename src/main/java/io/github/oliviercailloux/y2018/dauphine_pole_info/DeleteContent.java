package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("DeleteContent")
public class DeleteContent {
	
	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("dauphine");
	static Logger log;
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public Response Delete(@PathParam("id") int id) throws Exception {
		  EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
	      EntityTransaction transaction = null;
	      transaction = manager.getTransaction();
	      transaction.begin();
	      Content cont = manager.find(Content.class, id);
	      manager.remove(cont);
	      transaction.commit();
	      manager.close();
	      return Response.ok("ok").build();
	    }
	
	}

