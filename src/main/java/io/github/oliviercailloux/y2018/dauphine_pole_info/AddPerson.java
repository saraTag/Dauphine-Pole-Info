package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionalException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("addPerson")
@Stateless
public class AddPerson {

	@PersistenceContext()
	private EntityManager manager;

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public void add(@QueryParam("firstname") String fname, @QueryParam("lastname") String lname,
			@QueryParam("email") String email, @QueryParam("phone") String phone, @QueryParam("fax") String fax,
			@QueryParam("idMaster") int idMaster) {
		
		Master mast = null;
		mast = manager.find(Master.class, idMaster);
		Person per = new Person(fname, lname, email, phone, fax,mast);
		per.setMaster(mast);
		manager.persist(per);

	}

}