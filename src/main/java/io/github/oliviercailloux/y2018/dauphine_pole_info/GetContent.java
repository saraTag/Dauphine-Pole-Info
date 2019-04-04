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
import javax.transaction.SystemException;
import javax.transaction.TransactionalException;
import javax.transaction.UserTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("GetContent")
@Stateless
public class GetContent {

	@PersistenceContext(unitName = "dauphine")
    private EntityManager manager;

	@GET
	@Path("all")
	public List<Content> getAllContents(){

		List<Content> contents = null;
		List<Content> cont = new ArrayList<Content>();
		contents = manager.createQuery("SELECT s FROM Content s", Content.class).getResultList();
		for (Content entity : contents) {
			cont.add(entity);
		}
		return cont;

	}

	@GET
	@Path("one")
	public Content getContent(@QueryParam("id") int id) {

		Content cont = null;
		cont = manager.find(Content.class, id);
		return cont;

	}

}
