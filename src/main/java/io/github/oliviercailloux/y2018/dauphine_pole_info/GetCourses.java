package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.util.ArrayList;
import java.util.List;
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
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("GetCourse")
@Stateless
public class GetCourses {


	@PersistenceContext(unitName = "dauphine")
	private EntityManager manager;

	@GET
	public List<Course> getCourse() throws Throwable, SystemException {

		List<Course> cont = new ArrayList<Course>();
		Query q = manager.createQuery("SELECT s FROM Course s ", Course.class);
		List<Course> contents = q.getResultList();
		for (Course entity : contents) {
			cont.add(entity);
		}
		return cont;
	}
}
