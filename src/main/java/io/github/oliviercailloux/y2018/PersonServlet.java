package io.github.oliviercailloux.y2018;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/person")
public class PersonServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	//Temporary fake database
	@Inject
	private DatabaseManager DBM;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType("application/json");
		resp.setLocale(Locale.ENGLISH);
		
		PrintWriter out = resp.getWriter();
		Person targetPerson = DBM.getPersonsById().get(Integer.parseInt(id));
		out.print(targetPerson.personneToJson());
		out.flush();
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType("application/json");
		resp.setLocale(Locale.ENGLISH);
		
		
		//Ensures id parameter exists
		if(id != null) {
			if(req.getParameter("person")!=null) {
				//JSON request
				DBM.updatePersonne(Integer.parseInt(id), Person.jsonToPerson(req.getParameter("person")));
			}
//			else if(req.getParameter("id")!=null && req.getParameter("prenom")!=null && req.getParameter("nom")!=null) {
//				//Fields request
//				//Create JsonObject to be able to update course
//				updated = current.jsonToRole(Json.createObjectBuilder()
//						.add("id",req.getParameter("id"))
//						.add("prenom", req.getParameter("prenom"))
//						.add("nom", req.getParameter("nom"))
//						.add("email", req.getParameter("email"))
//						.add("telephone", req.getParameter("telephone"))
//						.add("fax", req.getParameter("fax"))
//						.add("home_page", req.getParameter("home_page"))
//						.add("cv", req.getParameter("cv"))
//						.add("note", req.getParameter("note"))
//						.add("password", req.getParameter("password"))
//						.add("role", req.getParameter("role"))
//						.add("annnee_master", req.getParameter("annee_master"))
//						.add("adresse", req.getParameter("adresse"))
//						.add("mobile", req.getParameter("mobile"))
//						.add("vacataire", req.getParameter("vacataire"))
//						.build());
//				DBM.updatePersonne(i, updated);
//			}
		}
		else {
			//Wrong Parameters
			PrintWriter out = resp.getWriter();
			out.print("Wrong parameters : expecting either a complete JSON or all the fields of a Personne individually");
			out.flush();
		}
	}
}
