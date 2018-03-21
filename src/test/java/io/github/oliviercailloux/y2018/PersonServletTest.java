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


public class PersonServletTest {

	private static final Logger LOGGER = Logger.getLogger(PersonServletTest.class.getCanonicalName());

	@Deployment(testable = false)
	public static WebArchive createDeployment() {
		final WebArchive war = ShrinkWrap.create(WebArchive.class, "test.war").addPackages(true,
				PersonServletTest.class.getPackage());
		return war;
	}
	
	@ArquillianResource
	private URL baseURL;
	
	@Test
	public void testDoGet() throws Exception{
		final Client client = ClientBuilder.newClient();
		final WebTarget webTarget = client.target(baseURL.toString()).path("/person").resolveTemplate("id", 1); 
		LOGGER.info(webTarget.getUri().toString());
		final String response = webTarget.request(MediaType.APPLICATION_JSON).get(String.class);
		assertEquals("{\"id\" : \"1\", \"firstname\" : \"Tuti\",\"lastname\" : \"Dudi\"}", response);
		client.close();
	}
}
