package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Servlet implementation class PreferenceServlet
 */
@WebServlet("/studentPreference")
public class StudentPrefServlet extends HttpServlet {
	
	

	@Inject
	private DatabaseManager DBM;


	
	protected void  doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStudent = req.getParameter("id");
		
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType("application/json");
		resp.setLocale(Locale.ENGLISH);
		PrintWriter out = resp.getWriter();
		List<RawPreference> preferences = DBM.getPreferencesByStudentId(Integer.parseInt(idStudent));
		Jsonb jsonb = JsonbBuilder.create();
		String result = jsonb.toJson(preferences);
		Response.status(Response.Status.OK).entity(result).build();
		out.print(result);

	}
	
	@GET
	@Consumes("text/plain")
	@Transactional
    public Response getPrefByCourse(String idCourse) throws IOException {
		
		List<RawPreference> preferences = DBM.getPreferencesByCourseId(Integer.parseInt(idCourse));
		Jsonb jsonb = JsonbBuilder.create();
		String result = jsonb.toJson(preferences);
		return Response.status(Response.Status.OK).entity(result).build();
    }
	
	@POST
	@Consumes("text/plain")
	@Transactional
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idPerson = Integer.parseInt(req.getParameter("idPerson"));
		int idMaster = Integer.parseInt(req.getParameter("idMaster"));
		int idContent = Integer.parseInt(req.getParameter("idContent"));
		int level = Integer.parseInt(req.getParameter("level"));

		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType("application/json");
		resp.setLocale(Locale.ENGLISH);

		RawPreference pref = new RawPreference(level);
		Content content = DBM.getContentsById().get(idContent);
		pref.setContent(content);
		Master master = DBM.getMastersById().get(idMaster);
		pref.setMaster(master);
		Person person = DBM.getPersonsById().get(idPerson);
		pref.setPerson(person);
		DBM.setPreference(idPerson, pref);
		
	}
}
