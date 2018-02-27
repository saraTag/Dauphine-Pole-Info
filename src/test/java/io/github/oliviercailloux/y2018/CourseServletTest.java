package io.github.oliviercailloux.y2018;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

public class CourseServletTest {

	private CourseServlet courseServlet;
	private DatabaseManager db;
	private HttpServletRequest request;       
	private HttpServletResponse response;

	@Before
	public void setUp() {
		courseServlet = new CourseServlet();
		db = new DatabaseManager();
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class); 
	}

	@Test
	public void testDoGet() throws Exception{
		request.setAttribute("periode", "2017");
		request.setAttribute("compulsory", true);
		request.setAttribute("description", "Java");
		courseServlet.doGet(request, response); 
		assertEquals("{\"periode\" : \"2017\", \"compulsory\" : \"true\",\"description\" : \"Java\"}", response.getContentType());

	}
	
	@Test
	public void testDoPost() throws Exception{
		request.setAttribute("id", 2);
		request.setAttribute("periode", "2018");
		request.setAttribute("compulsory", true);
		request.setAttribute("description", "Agile");	
		courseServlet.doPost(request, response);
		assertEquals(db.getCoursesById().get(2).getDescription(), "Agile");
	}


}
