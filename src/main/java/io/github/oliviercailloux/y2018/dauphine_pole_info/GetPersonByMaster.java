package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.TransactionalException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("GetPersonByMaster")
public class GetPersonByMaster {

	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("dauphine");
	static Logger log;

	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public List<Person> getPersonByMaster(@QueryParam("master") int master) throws Exception {

		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		List<Person> per = new ArrayList<Person>();
		transaction = manager.getTransaction();
		transaction.begin();
		Query q = manager.createQuery("SELECT s FROM Person s WHERE s.master = " + master, Person.class);
		List<Person> persons = q.getResultList();
		transaction.commit();
		manager.close();
		for (Person entity : persons) {
			per.add(entity);
		}
		return per;
	}
}
