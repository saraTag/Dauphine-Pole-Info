package io.github.oliviercailloux.y2018.dauphine_pole_info;

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
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/course")
@WebServlet("/course")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Temporary fake database
	@Inject
	private DatabaseManager DBM;

	// Handles GET requests on /course URL
	@GET()
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.APPLICATION_JSON);
		resp.setLocale(Locale.ENGLISH);
		PrintWriter out = resp.getWriter();

		String id = req.getParameter("id");
		if (id != null) {
			Course targetCourse = DBM.getCoursesById().get(Integer.parseInt(id));
			out.print(targetCourse.toJson());
		} else {
			out.print("Can't find a course : no ID passed as parameter");
		}
	}

	@PUT()
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType("application/json");
		resp.setLocale(Locale.ENGLISH);

		PrintWriter out = resp.getWriter();

		if (id != null) {
			if (req.getParameter("course") != null) {
				DBM.updateCourse(Integer.parseInt(id), Course.fromJson(req.getParameter("course")));
			} else {
				Course course = DBM.getCoursesById().get(Integer.parseInt(id));
				if (req.getParameter("periode") != null) {
					course.setPeriode(req.getParameter("periode"));
				}
				if (req.getParameter("compulsory") != null) {
					course.setPeriode(req.getParameter("compulsory"));
				}
				if (req.getParameter("description") != null) {
					course.setPeriode(req.getParameter("description"));
				}
				DBM.updateCourse(Integer.parseInt(id), course);
				out.print("Succesfuly created/replaced Course : " + course.toJson());
			}
		}

		else {
			// Wrong Parameters
			out.print("Wrong parameters : expecting either a complete JSON or all the fields of a Course individually");
		}
	}
}
