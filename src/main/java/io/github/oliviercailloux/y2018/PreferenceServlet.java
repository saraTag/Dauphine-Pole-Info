package io.github.oliviercailloux.y2018;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PreferenceServlet
 */
@WebServlet("/PreferenceServlet")
public class PreferenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Temporary fake database
	@Inject
	private DatabaseManager DBM;

	/**
	 * getPref
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType("application/json");
		resp.setLocale(Locale.ENGLISH);
		
		PrintWriter out = resp.getWriter();
		ArrayList<Preference> preferences = DBM.getPreferencesByStudentId(Integer.parseInt(id));
		preferences.forEach(preference -> out.print(preference.preferenceToJson()));
	}

	/**
	 * setPref
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idPerson = Integer.parseInt(req.getParameter("idPerson"));
		int idMaster = Integer.parseInt(req.getParameter("idMaster"));
		int idContent = Integer.parseInt(req.getParameter("idContent"));
		int level = Integer.parseInt(req.getParameter("level"));
		
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType("application/json");
		resp.setLocale(Locale.ENGLISH);
		
		Preference pref = new Preference(level);
		pref.setId_contents(idContent);
		pref.setId_master(idMaster);
		pref.setId_person(idPerson);
		
		DBM.setPreference(idPerson, pref);
	}

}
