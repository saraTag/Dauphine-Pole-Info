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
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.TransactionalException;
import javax.transaction.UserTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("GetPerson")
@Stateless
public class GetPerson {

	
	@PersistenceContext(unitName = "dauphine")
    private EntityManager manager;

	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAllPersons() {
		List<Person> persons = null;
		List<Person> per = new ArrayList<Person>();
		persons = manager.createQuery("SELECT s FROM Person s", Person.class).getResultList();
		for (Person entity : persons) {
			per.add(entity);
		}
		return per;
	}

	@GET
	@Path("one")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson(@QueryParam("id") int id) {
		Person pers = null;
		pers = manager.find(Person.class, id);
		return pers;

	}
}
