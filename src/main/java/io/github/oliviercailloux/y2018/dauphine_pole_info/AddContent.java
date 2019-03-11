package io.github.oliviercailloux.y2018.dauphine_pole_info;


import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.TransactionalException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@RequestScoped
@Path("AddContent")
public class AddContent {

	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("dauphine");
	static Logger log;
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public Response add(@QueryParam("name") String name) {
		
		Content cont =new Content(name);
		CreateContent(cont);
		return Response.ok("ok").build();
	}
	
	void CreateContent(Content cont) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            cont.setId(cont.getId());
            cont.setName(cont.getName());
            cont.setHourlyVolume(cont.getHourlyVolume());
            cont.setEtcs(cont.getEtcs());
            cont.setProjectVolume(cont.getProjectVolume());

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
    }
}
