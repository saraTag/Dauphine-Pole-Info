package io.github.oliviercailloux.y2018;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;


@WebServlet("/person")
public class PersonServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(PersonServlet.class.getCanonicalName());
	//
	//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
	//		resp.setContentType(MediaType.TEXT_PLAIN);
	//		resp.setLocale(Locale.ENGLISH);
	//		final ServletOutputStream out = resp.getOutputStream();
	//		LOGGER.info("Hello, world."); 
	//		out.println("Hello, world!!!.");
	//	}

	//Temporary fake database
	@Inject
	private DatabaseManager DBM;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.APPLICATION_JSON);
		resp.setLocale(Locale.ENGLISH);
		PrintWriter out = resp.getWriter();
		Map<Integer,	Person> map;
		String id = req.getParameter("id");
		if(id != null) {
			LOGGER.info("id:" + id); 

			 map = DBM.getPersonsById();
			LOGGER.info("Map : " + map); 
			Person targetPerson = map.get(Integer.parseInt(id));
			LOGGER.info("person" + targetPerson != null ? targetPerson.getFirstname() : "is null"); 
			out.print(targetPerson.toJson());
			out.flush();
		}
		else {
			LOGGER.info("DBM db: " + DBM); 
			out.print("id not exist");
		}
	}


	//		@Override
	//		protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//			String id = req.getParameter("id");
	//			
	//			resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
	//			resp.setContentType("application/json");
	//			resp.setLocale(Locale.ENGLISH);
	//	
	//			//Ensures id parameter exists
	//			if(id != null) {
	//				if(req.getParameter("person")!=null) {
	//					//JSON request
	//					DBM.updatePerson(Integer.parseInt(id), Person.fromJson(req.getParameter("person")));
	//				}
	//	
	//				else {
	//					Person person = DBM.getPersonsById().get(Integer.parseInt(id));
	//					if(req.getParameter("firstname") != null) {
	//						person.setFirstname(req.getParameter("firstname"));
	//					}
	//					if(req.getParameter("lastname") != null) {
	//						person.setLastname(req.getParameter("lastname"));
	//					}
	//					DBM.updatePerson(Integer.parseInt(id), person);
	//				}
	//			}
	//			else {
	//				//Wrong Parameters code  status envoyer une exception
	//				PrintWriter out = resp.getWriter();
	//				out.print("Wrong parameters : expecting a complete JSON");
	//			}
	//		}
}
