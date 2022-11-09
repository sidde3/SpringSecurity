package org.example.demo;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelloIT {
	
	private static String port, name;
	
	@Before
	public void setup() {
		port = System.getProperty("servlet.port", "8080");
		name = System.getProperty("artifactId", "SpringSecurity");
	}

	@Test
	public void hello() throws IOException {
		String testName = "testname";
		HttpURLConnection connection = (HttpURLConnection)new URL("http://localhost:" + port  + '/' + name +"/home?name="+testName).openConnection();
		{
			connection.connect();
			assertEquals(200, connection.getResponseCode());
			
			try (InputStream in = connection.getInputStream()) {
				String output = IOUtils.toString(in);
				assertTrue("Sent name not found in page  with source \n" + output, output.contains(testName));
			}
		}
	}

}