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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("GetContent")
public class GetContent {
	
	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("dauphine");
	static Logger log;
	
	@GET
	@Path("all")
	@Produces(MediaType.TEXT_PLAIN)
	public List<Content> getAllContents() {
		
		 List<Content> contents = null;
		 List<Content> cont = new ArrayList<Content>();

	        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
	        EntityTransaction transaction = null;

	        try {
	            transaction = manager.getTransaction();
	            transaction.begin();

	            contents = manager.createQuery("SELECT s FROM Content s",
	                    Content.class).getResultList();
	            transaction.commit();
	        } catch (Exception ex) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            ex.printStackTrace();
	        } finally {
	            manager.close();
	        }
	        for (Content entity : contents) {
	        	cont.add(entity);
	        }
	        return cont;
		
	}
	@GET
	@Path("one")
	@Produces(MediaType.TEXT_PLAIN)
	public Content getContent(@PathParam("id") int id) {

    	Content cont = null;
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

             cont = manager.find(Content.class, id);
            transaction.commit();
        } catch (TransactionalException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.log(Level.SEVERE, "an exception was thrown", e);
        } finally {
            manager.close();
        }
		return cont;
	
	}

}
