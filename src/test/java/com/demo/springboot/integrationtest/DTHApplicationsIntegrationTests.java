package com.demo.springboot.integrationtest;

import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class DTHApplicationsIntegrationTests {

	 @LocalServerPort
	    private int port;
	    TestRestTemplate restTemplate = new TestRestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void testRetrieveStudent() throws Exception {
	    HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	    ResponseEntity<String> response = restTemplate.exchange(
	      createURLWithPort("/users/10099/channels"), HttpMethod.GET, entity, String.class);
	    String expected = "[{\"id\":\"CH004\",\"name\":\"CNN\",\"src\":\"images/cnn_logo.png\"},{\"id\":\"CH005\",\"name\":\"BBC\",\"src\":\"images/bbc_logo.png\"},{\"id\":\"CH006\",\"name\":\"TIMES NOW\",\"src\":\"images/times_now_logo.png\"},{\"id\":\"CH007\",\"name\":\"Star Sports\",\"src\":\"images/star_sports_logo.png\"}]";
	    JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	private String createURLWithPort(String uri) {
	    return "http://localhost:" + port + uri;
	}
}


