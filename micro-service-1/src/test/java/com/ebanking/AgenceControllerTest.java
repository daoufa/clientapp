package com.ebanking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.net.URI;

import javax.transaction.Transactional;

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

import com.ebanking.model.Agence;
import com.ebanking.repository.AgenceRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AgenceControllerTest {
	@Autowired
	private AgenceRepository agenceRepository;
	@LocalServerPort
	int randomServerPort;
	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void creerAgenceTest() throws Exception {
		final String baseUrl = "http://localhost:" + randomServerPort + "/creerAgence";
		URI uri = new URI(baseUrl);
		Agence a = new Agence("agenceTOP", "rue Casa", "casa");

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<Agence> request = new HttpEntity<>(a, headers);

		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

		// Verify request succeed
		assertThat(result.getStatusCodeValue() == 201);
	}

	@Test
	public void deletAgenceTest() throws Exception {
		final String baseUrl = "http://localhost:" + randomServerPort + "/deletAgence";
		URI uri = new URI(baseUrl);
		Agence a = new Agence("agenceTOP", "rue Casa", "casa");
		a = agenceRepository.save(a);
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<Long> request = new HttpEntity<>(a.getId(), headers);

		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

		// Verify request succeed
		assertThat(result.getStatusCodeValue() == 200);
	}

	@Test
	@Transactional
	public void editAgenceTest() throws Exception {
		Agence a = new Agence("agenceTOP", "rue Casa", "casa");
		a = agenceRepository.save(a);
		mockMvc.perform(get("/editAgence").param("idagence", a.getId().toString()))
				.andExpect(model().attribute("editAgence", equalTo(a))).andExpect(status().isOk())
				.andExpect(view().name("agence"));

	}
}
