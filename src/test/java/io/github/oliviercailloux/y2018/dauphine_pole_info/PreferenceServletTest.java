package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class PreferenceServletTest {

	@Deployment(testable = false)
	public static WebArchive createDeployment() {
		final WebArchive war = ShrinkWrap.create(WebArchive.class, "test.war").addPackages(true,
				PreferenceServletTest.class.getPackage());
		return war;
	}

	@ArquillianResource
	private URL baseURL;

	@Test
	public void testDoGet() throws Exception {
	}
}
