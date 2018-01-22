package io.github.oliviercailloux.y2018.web;

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

import io.github.oliviercailloux.y2018.Personne;

@WebServlet("/person")
public class getPersonServlet extends HttpServlet{
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
		Personne targetPerson = DBM.getPersonsById().get(Integer.parseInt(id));
		out.print(targetPerson);
		out.flush();
	}
}
