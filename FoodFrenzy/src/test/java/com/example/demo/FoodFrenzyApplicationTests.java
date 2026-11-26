package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.menu.MenuCatalog;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class FoodFrenzyApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MenuCatalog menuCatalog;

	@Test
	void contextLoads() {
	}

	@Test
	void foodiemePublicPagesRender() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("FoodieMe")));

		mockMvc.perform(get("/products"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Veg Spring Rolls")))
				.andExpect(content().string(containsString("Kulfi")))
				.andExpect(content().string(containsString("₹120")));

		mockMvc.perform(get("/register"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Join Foodie")));

		mockMvc.perform(get("/reviews"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Tell us how it")));

		mockMvc.perform(get("/location"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/reviews"));
	}

	@Test
	void invalidRegistrationReturnsHelpfulFormErrors() throws Exception {
		mockMvc.perform(post("/register").param("uemail", "not-an-email"))
				.andExpect(status().isOk())
				.andExpect(view().name("register"))
				.andExpect(content().string(containsString("Please enter a valid email address.")));
	}

	@Test
	void foodiemeMenuContainsAllSeventyRequestedItems() {
		int itemCount = menuCatalog.getSections().stream()
				.mapToInt(section -> section.getItems().size())
				.sum();

		assertEquals(70, itemCount);
	}

}
