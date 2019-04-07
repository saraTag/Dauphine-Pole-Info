package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.SystemException;
import javax.transaction.TransactionalException;
import javax.transaction.UserTransaction;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("UpdateMaster")
@Stateless
public class UpdateMaster {

	@PersistenceContext()
<<<<<<< HEAD
	private EntityManager manager;
=======
    	private EntityManager manager;
>>>>>>> d96be3f37a93b43f4960d4ce3f523258cbde33bb

	@PUT
	public void Update(@QueryParam("id") int id, @QueryParam("name") String name,
			@QueryParam("description") String description) {

		Master mast = manager.find(Master.class, id);
		mast.setName(name);
		mast.setDescription(description);
		manager.persist(mast);

	}

}
