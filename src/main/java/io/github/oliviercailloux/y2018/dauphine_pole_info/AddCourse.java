package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("addCourse")
public class AddCourse {
	
	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("dauphine");

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public void add(@QueryParam("master") int master, @QueryParam("content") int content,
			@QueryParam("enseignat") int enseigant, @QueryParam("notes") String notes)
			throws NullPointerException {
		
		Master mast = new Master();
		Content cont = new Content();
		CourseId coursid = new CourseId(mast,cont);
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

	void createCours(Course cours) throws NullPointerException {

		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		transaction = manager.getTransaction();
		transaction.begin();
		cours.setId(cours.getId());
		cours.setTeacher(cours.getTeacher());
		cours.setDescription(cours.getDescription());
		manager.persist(cours);
		transaction.commit();
		manager.close();

	}


}
