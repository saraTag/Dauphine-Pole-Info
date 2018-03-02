package io.github.oliviercailloux.y2018;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PreferencesByCourse
 */
@WebServlet("/PreferencesByCourse")
public class PreferencesByCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	//Temporary fake database
	@Inject
	private DatabaseManager DBM;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType("application/json");
		resp.setLocale(Locale.ENGLISH);
		
		PrintWriter out = resp.getWriter();
		ArrayList<Preference> preferences = DBM.getPreferencesByCourseId(Integer.parseInt(id));
		Jsonb jsonb = JsonbBuilder.create();
		out.print(jsonb.toJson(preferences));
		
		//Returns a series of JSON instead of a single JSON -> NO GOOD
		//preferences.forEach(preference -> out.print(preference.preferenceToJson()));
	}
}
