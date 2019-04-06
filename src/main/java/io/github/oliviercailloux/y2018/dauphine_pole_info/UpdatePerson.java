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
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.TransactionalException;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("updatePerson")
@Stateless
public class UpdatePerson {

	@PersistenceContext(unitName = "dauphine")
	private EntityManager manager;

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON})
	public Response Update(@QueryParam("id") int id, Person p) {
		Person pers = manager.find(Person.class,id);
		String data = p.getFirstname();
		pers.setFirstname(data);
		pers.setLastname(p.getLastname());
		pers.setEmail(p.getEmail());
		pers.setPhone(p.getPhone());
		pers.setFax(p.getFax());
		pers.setMaster(p.getMaster());
		manager.persist(pers);
		return Response.status(Response.Status.OK).build();
	}

}
