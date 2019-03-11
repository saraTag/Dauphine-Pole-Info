package io.github.oliviercailloux.y2018;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.TransactionalException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("UpdateContent")
public class UpdateContent {
	
	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("dauphine");
	
	static Logger log;
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	public Response Update(@PathParam("id") int id,@QueryParam("name") String name) {
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            Content cont = manager.find(Content.class, id);
            cont.setName(name);
         
            manager.persist(cont);
            transaction.commit();
        } catch (TransactionalException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.log(Level.SEVERE, "an exception was thrown", e);
        } finally {
            manager.close();
        }
		return Response.ok("ok").build();
    }
	
}
