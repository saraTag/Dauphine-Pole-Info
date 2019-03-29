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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("UpdatePerson")
public class UpdatePerson {
	
	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("dauphine");
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	public void Update(@QueryParam("id") int id,@QueryParam("firstname") String fname,@QueryParam("lastname") String lname) throws NullPointerException{
		
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        transaction = manager.getTransaction();
        transaction.begin();
        Person pers = manager.find(Person.class, id);
        pers.setId(id);
        pers.setFirstname(fname);
        pers.setLastname(lname);
        manager.persist(pers);
        transaction.commit();
        manager.close();
    
	}
	
}
