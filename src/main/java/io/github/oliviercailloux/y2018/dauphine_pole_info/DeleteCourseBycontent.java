package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("DeleteCourseByContent")
public class DeleteCourseBycontent {

	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("dauphine");

	@Transactional
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public void Delete(@QueryParam("contents") int contents) throws Exception {

		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		transaction = manager.getTransaction();
		transaction.begin();
		int q = manager.createQuery("DELETE  FROM Course s WHERE s.id.contents = " + contents).executeUpdate();
		transaction.commit();
		manager.close();
	}

}
