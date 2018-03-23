package io.github.oliviercailloux.y2018;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;

public class CourseServletTest {

	private static final Logger LOGGER = Logger.getLogger(CourseServletTest.class.getCanonicalName());

	@Deployment(testable = false)
	public static WebArchive createDeployment() {
		final WebArchive war = ShrinkWrap.create(WebArchive.class, "test.war").addPackages(true,
				CourseServletTest.class.getPackage());
		return war;
	}
	
	@ArquillianResource
	private URL baseURL;
	
	
	@Test
	public void testDoGet() throws Exception{
		final Client client = ClientBuilder.newClient();
		final WebTarget webTarget = client.target(baseURL.toString()).path("/course").resolveTemplate("id", 2); 
		LOGGER.info(webTarget.getUri().toString());
		final String response = webTarget.request(MediaType.APPLICATION_JSON).get(String.class); 
		assertEquals("{\"periode\" : \"2017\", \"compulsory\" : \"true\",\"description\" : \"Java\"}", response);
	}

}