package com.ebanking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.ebanking.config.Authentication;
import com.ebanking.model.Agence;
import com.ebanking.model.Agent;
import com.ebanking.repository.AgenceRepository;
import com.ebanking.repository.AgentRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AgentControllerTest {
	@Autowired
	private Authentication authenticated;
	@Autowired
	private AgenceRepository agenceRepository;
	@Autowired
	private AgentRepository agentRepository;
	@LocalServerPort
	int randomServerPort;
	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void agentViewTest() throws Exception {
		Agence a = new Agence("agenceTOP", "rue Casa", "casa");
		authenticated.setAuthenticated(true);
		a = agenceRepository.save(a);
		mockMvc.perform(get("/agent").param("idagence", a.getId().toString()).param("isModifier", "false"))
				.andExpect(model().attribute("agence", equalTo(a)))
				.andExpect(model().attribute("nvAgent", equalTo(new Agent())))
				.andExpect(model().attribute("isModifier", equalTo(false))).andExpect(status().isOk())
				.andExpect(view().name("agent"));

	}

	@Test
	public void creerAgentTest() throws Exception {
		authenticated.setAuthenticated(true);
		Agent agent = new Agent("daoufa", "abderrahman", "maroc", "casa", "00636", "df@gmail", "ee", null);
		Agence agence = new Agence("agenceTOP", "rue Casa", "casa");
		agence = agenceRepository.save(agence);
		final String baseUrl = "http://localhost:" + randomServerPort + "/creerAgent?idagence=" + agence.getId();
		URI uri = new URI(baseUrl);

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<Agent> request = new HttpEntity<>(agent, headers);

		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

		// Verify request succeed
		assertThat(result.getStatusCodeValue() == 201);
	}

	@Test
	public void deletAgentTest() throws Exception {
		authenticated.setAuthenticated(true);
		final String baseUrl = "http://localhost:" + randomServerPort + "/deletAgent";
		URI uri = new URI(baseUrl);
		Agent agent = new Agent("daoufa", "abderrahman", "maroc", "casa", "00636", "df@gmail", "ee", null);
		agent = agentRepository.save(agent);
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<Long> request = new HttpEntity<>(agent.getCode(), headers);

		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

		// Verify request succeed
		assertThat(result.getStatusCodeValue() == 200);
	}

}
