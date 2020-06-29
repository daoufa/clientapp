package com.ebanking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.ebanking.config.Authentication;
import com.ebanking.config.GlobalParam;
import com.ebanking.model.Agence;
import com.ebanking.repository.AgenceRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTest {
	@Autowired
	private AgenceRepository agenceRepository;
	@Autowired
	private GlobalParam globalParam;
	@Autowired
	private Authentication authenticated;
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void homeRedirectTest() throws Exception {
		authenticated.setAuthenticated(true);
		mockMvc.perform(get("/")).andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/index"));
	}

	@Test
	@Transactional
	public void indexTest() throws Exception {
		authenticated.setAuthenticated(true);
		List<Agence> agences = agenceRepository.findAll();
		mockMvc.perform(get("/index").param("isModifier", "false"))
				.andExpect(model().attribute("agences", equalTo(agences)))
				.andExpect(model().attribute("isModifier", equalTo(false)))
				.andExpect(model().attribute("nvAgence", equalTo(new Agence()))).andExpect(status().isOk())
				.andExpect(view().name("index"));

	}

	@Test
	public void globalParamTest() throws Exception {
		authenticated.setAuthenticated(true);
		mockMvc.perform(get("/globalParam"))
				.andExpect(model().attribute("tauxInterets", equalTo(globalParam.getTauxInterets())))
				.andExpect(model().attribute("decouvert", equalTo(globalParam.getDecouvert())))
				.andExpect(status().isOk()).andExpect(view().name("globalParam"));

	}

	@Test
	public void setGlobalParamTest() throws Exception {
		authenticated.setAuthenticated(true);
		mockMvc.perform(post("/setGlobalParam").param("tauxInterets", "1.5").param("decouvert", "2.5"))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("index"));

		assertThat(globalParam.getDecouvert() == 0.5 && globalParam.getTauxInterets() == 1.5);
	}

	@Test
	public void profileTest() throws Exception {
		authenticated.setAuthenticated(true);
		mockMvc.perform(get("/profile")).andExpect(status().isOk()).andExpect(view().name("profile"));
	}
}
