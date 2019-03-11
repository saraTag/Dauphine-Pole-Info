package io.github.oliviercailloux.y2018.dauphine_pole_info;

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
import javax.ws.rs.core.MediaType;

/**
 * Servlet implementation class PreferencesByCourse
 */
@WebServlet("/PreferencesByCourse")
public class PreferencesByCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Temporary fake database
	@Inject
	private DatabaseManager DBM;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.APPLICATION_JSON);
		resp.setLocale(Locale.ENGLISH);
		PrintWriter out = resp.getWriter();
		ArrayList<RawPreference> preferences = DBM.getPreferencesByCourseId(Integer.parseInt(id));
		preferences.forEach(preference -> out.print(preference.preferenceToJson()));
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		response.setContentType(MediaType.APPLICATION_JSON);
		response.setLocale(Locale.ENGLISH);
		PrintWriter out = response.getWriter();
		doGet(request, response);
		ArrayList<RawPreference> preferences = DBM.getPreferencesByCourseId(Integer.parseInt(id));
		Jsonb jsonb = JsonbBuilder.create();
		out.print(jsonb.toJson(preferences));
	}
}
