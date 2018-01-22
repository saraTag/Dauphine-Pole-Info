package io.github.oliviercailloux.y2018.web;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import io.github.oliviercailloux.y2018.Cours;

@WebServlet("/course")
public class courseServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	//Temporary fake database
	@Inject
	private DatabaseManager DBM;
	
	//Handles GET requests on /course URL
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType("application/json");
		resp.setLocale(Locale.ENGLISH);
		
		PrintWriter out = resp.getWriter();
		Cours targetCourse = DBM.getCoursesById().get(Integer.parseInt(id));
		out.print(targetCourse);
		out.flush();
	}
	
	//Handles POST requests, for both ways of updating a course
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType("application/json");
		resp.setLocale(Locale.ENGLISH);
		
		
		//Ensures id parameter exists
		if(id != null) {
			int i = Integer.parseInt(id);
			Cours current = DBM.getCoursesById().get(i);
			Cours updated;
			if(req.getParameter("course")!=null) {
				//JSON request
				String course = req.getParameter("course");
				
				//Read JsonObject from String parameter
				JsonReader jsonReader = Json.createReader(new StringReader(course));
				JsonObject jsonParameter = jsonReader.readObject();
				jsonReader.close();
				
				updated = current.jsonToCours(jsonParameter);
				DBM.updateCourse(i, updated);
			}
			else if(req.getParameter("periode")!=null && req.getParameter("obligatoire")!=null && req.getParameter("note")!=null) {
				//Fields request
				//Create JsonObject to be able to update course
				updated = current.jsonToCours(Json.createObjectBuilder().add("periode", req.getParameter("periode") )
						.add("obligatoire", req.getParameter("obligatoire"))
						.add("note", req.getParameter("note"))
						.build());
				DBM.updateCourse(i, updated);
			}
		}
		else {
			//Wrong Parameters
			PrintWriter out = resp.getWriter();
			out.print("Wrong parameters : expecting either a complete JSON or all the fields of a Course individually");
			out.flush();
		}
	}
}
