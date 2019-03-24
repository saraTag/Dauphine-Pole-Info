package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("GetCourseByContent")
public class GetcourseByContent {
	
	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("dauphine");
	static Logger log;

	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public List<Course> getCourseByMaster(@QueryParam("contents") int contents) throws Exception {

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<Course> cont = new ArrayList<Course>();
        transaction = manager.getTransaction();
        transaction.begin();
        Query q = manager.createQuery("SELECT s FROM Course s WHERE s.id.contents = "+contents,Course.class);
        List<Course >content = q.getResultList();
        transaction.commit();
        manager.close();
        for (Course entity : content) {
        	cont.add(entity);
        }
        return cont;
	}

}
