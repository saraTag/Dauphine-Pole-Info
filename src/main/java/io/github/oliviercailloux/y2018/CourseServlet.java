package io.github.oliviercailloux.y2018;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/course")
@WebServlet("/course")
public class CourseServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	//Temporary fake database
	@Inject
	private DatabaseManager DBM;

	//Handles GET requests on /course URL
	@GET()
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.APPLICATION_JSON);
		resp.setLocale(Locale.ENGLISH);
		PrintWriter out = resp.getWriter();

		String id = req.getParameter("id");
		Course targetCourse = DBM.getCoursesById().get(Integer.parseInt(id));
		out.print(targetCourse.toJson());
		out.flush();
	}
	
	@PUT()
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType("application/json");
		resp.setLocale(Locale.ENGLISH);

		if(id != null) {
			if(req.getParameter("course")!=null) {
				DBM.updateCourse(Integer.parseInt(id), Course.fromJson(req.getParameter("course")));
			}
			else {
				Course course = DBM.getCoursesById().get(Integer.parseInt(id));
				if(req.getParameter("periode") != null) {
					course.setPeriode(req.getParameter("periode"));
				}
				if(req.getParameter("compulsory") != null) {
					course.setPeriode(req.getParameter("compulsory"));
				}
				if(req.getParameter("description") != null) {
					course.setPeriode(req.getParameter("description"));
				}
				DBM.updateCourse(Integer.parseInt(id), course);
			}
		}
		
		else {
			// Wrong Parameters
			PrintWriter out = resp.getWriter();
			out.print("Wrong parameters : expecting either a complete JSON or all the fields of a Course individually");
			out.flush();
		}
	}
}
