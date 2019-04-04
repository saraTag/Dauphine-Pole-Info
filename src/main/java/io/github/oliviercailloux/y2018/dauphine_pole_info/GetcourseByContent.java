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
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("GetCourseByContent")
@Stateless
public class GetcourseByContent {


	@PersistenceContext()
    private EntityManager manager;
	
	@GET
	public List<Course> getCourseByMaster(@QueryParam("contents") int contents) throws Throwable, SystemException  {

		List<Course> cont = new ArrayList<Course>();
		Query q = manager.createQuery("SELECT s FROM Course s WHERE s.id.contents = " + contents, Course.class);
		List<Course> content = q.getResultList();
		for (Course entity : content) {
			cont.add(entity);
		}
		return cont;
	}

}
