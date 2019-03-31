package io.github.oliviercailloux.y2018.dauphine_pole_info;

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
import javax.transaction.UserTransaction;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("addCourse")
@Stateless
public class AddCourse {

	@PersistenceContext(unitName = "dauphine")
	private EntityManager manager;

	@POST
	public void add(@QueryParam("master") int master, @QueryParam("content") int content,
			@QueryParam("enseignat") int enseigant, @QueryParam("notes") String notes) {

		Master mast = new Master();
		Content cont = new Content();
		CourseId coursid = new CourseId(mast, cont);
		Person enseignant = new Person();
		mast.setId(master);
		cont.setId(content);
		enseignant.setId(enseigant);

		Course cour = new Course();
		cour.setId(coursid);
		cour.setTeacher(enseignant);
		cour.setDescription(notes);
		createCours(cour);

	}

	void createCours(Course cours) {
		cours.setId(cours.getId());
		cours.setTeacher(cours.getTeacher());
		cours.setDescription(cours.getDescription());
		manager.persist(cours);

	}

}
