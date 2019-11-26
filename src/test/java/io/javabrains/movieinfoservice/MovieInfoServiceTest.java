package io.javabrains.movieinfoservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class MovieInfoServiceTest extends MovieInfoServiceApplicationTests{
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mvc;

	@Before
	public void setUp()
	{
		mvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void getMovieInfoTest() throws Exception
	{
		mvc.perform(get("/movies/1")).
			andExpect(status().isOk()).
			andExpect(content().contentType("application/json;charset=UTF-8"))
			.andExpect(jsonPath("$.movieId").value("1"));
	}
}
