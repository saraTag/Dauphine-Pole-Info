package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.util.Optional;
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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("AddContent")
@Stateless
public class AddContent {

	@PersistenceContext(unitName = "dauphine")
    private EntityManager manager;

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public void add(@QueryParam("name") String name){

		Content cont = new Content();
		cont.setName(name);
		manager.persist(cont);
	}

}
