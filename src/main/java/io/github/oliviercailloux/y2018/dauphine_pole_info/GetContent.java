package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.TransactionalException;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("getContent")
public class GetContent {
	
	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("dauphine");
	static Logger log;
	
	@PUT
	@Path("all")
	@Produces(MediaType.TEXT_PLAIN)
	public List<Content> getAllContents() throws Exception{
		
		 List<Content> contents = null;
		 List<Content> cont = new ArrayList<Content>();

	     EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
	     EntityTransaction transaction = null;
	     transaction = manager.getTransaction();
	     transaction.begin();
	     contents = manager.createQuery("SELECT s FROM Content s",Content.class).getResultList();
	     transaction.commit();
	     manager.close();
	     for (Content entity : contents) {
	        	cont.add(entity);
	        }
	     return cont;
		
	}
	
	@GET
	@Path("one")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPerson(@QueryParam("id") int id) throws Exception {
	
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("dauphine");
		EntityManager em = emFactory.createEntityManager();
		EntityTransaction transaction = null;
        transaction = em.getTransaction();
        transaction.begin();
        Content cont = em.find(Content.class, id);
        transaction.commit();
        em.close();
        //String result = cont.toJson();
        return Response.status(Response.Status.OK)
        		       .entity(cont)
		        	   .type("application/json")
		        	   .build();
	
	}

}
