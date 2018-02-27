package io.github.oliviercailloux.y2018;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;




public class PersonServletTest {

	private PersonServlet personServlet;
	private DatabaseManager db;
	private HttpServletRequest request;       
	private HttpServletResponse response;

	@Before
	public void setUp() {
		personServlet = new PersonServlet();
		db = new DatabaseManager();
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class); 
	}

	@Test
	public void testDoGet() throws Exception{
		request.setAttribute("id", 1);
		request.setAttribute("firstname", "Titi");
		request.setAttribute("lastname", "Dodo");
		personServlet.doGet(request, response); 
		assertEquals("{\"id\" : \"1\", \"firstname\" : \"Titi\",\"lastname\" : \"Dodo\"}", response.getContentType());

	}
	
	@Test
	public void testDoPost() throws Exception{
		request.setAttribute("id", 2);
		request.setAttribute("firstname", "Tete");
		request.setAttribute("firstname", "Dudi");	
		personServlet.doPost(request, response);
		assertEquals(db.getPersonsById().get(2).getFirstname(), "Tete");
		
	}


}
