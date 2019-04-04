package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.json.JsonObject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@RequestScoped
@Path("studentPreference")
public class StudentPrefServlet{
	
	@PersistenceContext
	private EntityManager entityManager;
	

	static Logger log = Logger.getLogger(StudentPrefServlet.class.getCanonicalName());;

	@GET
	@Transactional
	@Produces(MediaType.TEXT_PLAIN)
	@Path("getPref")
	public Response getPref(@PathParam("idStudent") String idStudent) throws ServletException, IOException {
		// getting the Student
		TypedQuery<Person> queryPerson = entityManager.createQuery("SELECT i FROM RawPreference i i.id = :idStudent",
				Person.class);
		Person student = queryPerson.setParameter("idStudent", idStudent).getSingleResult();

		TypedQuery<RawPreference> queryPreferences = entityManager
				.createQuery("SELECT i FROM RawPreference i i.Person = :student", RawPreference.class);

		List<RawPreference> allIpreferences = queryPreferences.setParameter("Person", student).getResultList();

		Set<RawPreference> setPreferences = null;

		for (RawPreference pref : allIpreferences) {
			setPreferences.add(pref);
		}
		StudentPreference studPref = new StudentPreference(student, setPreferences);

		Jsonb jsonb = JsonbBuilder.create();
		String result = jsonb.toJson(studPref);
		log.info(result);
		return Response.status(Response.Status.OK).entity(result).build();

	}
	


	@POST
	@Consumes({MediaType.APPLICATION_JSON ,MediaType.TEXT_PLAIN})
	
	@Transactional
	@Path("setPref")
	public void setPref(RawPreference pref, String idStudent) throws IOException {
		

		
		TypedQuery<Person> queryPerson = entityManager.createQuery("SELECT i FROM RawPreference i i.id = :idStudent",
				Person.class);
		
		Person student = queryPerson.setParameter("idStudent", idStudent).getSingleResult();

		pref.setPerson(student);

		
		entityManager.persist(pref);

		Response.status(Response.Status.OK).build();
	}

}