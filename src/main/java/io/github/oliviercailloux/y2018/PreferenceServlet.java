package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
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
 * Servlet implementation class PreferenceServlet
 */
@WebServlet("/preference")
public class PreferenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Temporary fake database
	@Inject
	private DatabaseManager DBM;

	/**
	 * getPref
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType("application/json");
		resp.setLocale(Locale.ENGLISH);
		PrintWriter out = resp.getWriter();
		if (id != null) {
			// According to the documentation, the following code should work
			// See :
			// https://benas.github.io/jsonb-spec/docs/user-guide.html#mapping-a-generic-collection
			// There seems to be an issue in the yasson implementation of the JSON-B API
			List<RawPreference> preferences = DBM.getPreferencesByStudentId(Integer.parseInt(id));
			Jsonb jsonb = JsonbBuilder.create();
			out.print(jsonb.toJson(preferences));
		} else {
			out.print("Can't find a Preference : Please provide an ID.");
		}
	}

	/**
	 * setPref
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
