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
				DBM.updatePerson(Integer.parseInt(id), Person.jsonToPerson(req.getParameter("person")));
			}

			else {
				Person person = DBM.getPersonsById().get(Integer.parseInt(id));
				if(req.getParameter("firstname") != null) {
					person.setFirstname(req.getParameter("firstname"));
				}
				if(req.getParameter("lastname") != null) {
					person.setLastname(req.getParameter("lastname"));
				}
				DBM.updatePerson(Integer.parseInt(id), person);
			}
		}
		else {
			//Wrong Parameters
			PrintWriter out = resp.getWriter();
			out.print("Wrong parameters : expecting a complete JSON");
		}
	}
}
