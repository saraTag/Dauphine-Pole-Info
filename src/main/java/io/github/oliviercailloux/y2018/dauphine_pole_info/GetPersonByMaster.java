package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.TransactionalException;
import javax.transaction.UserTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("GetPersonByMaster")
@Stateless
public class GetPersonByMaster {

	@PersistenceContext()
    private EntityManager manager;


	@GET
	public List<Person> getPersonByMaster(@QueryParam("master") int master)  {

		List<Person> per = new ArrayList<Person>();
		Query q = manager.createQuery("SELECT s FROM Person s WHERE s.master = " + master, Person.class);
		List<Person> persons = q.getResultList();
		for (Person entity : persons) {
			per.add(entity);
		}
		return per;
	}
}
