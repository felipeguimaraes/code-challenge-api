package com.felipeguimaraes.codechallenge.api.resource;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.felipeguimaraes.codechallenge.api.bean.Address;
import com.felipeguimaraes.codechallenge.api.bean.CoverageArea;
import com.felipeguimaraes.codechallenge.api.bean.Pdv;
import com.felipeguimaraes.codechallenge.api.repository.PdvMongoRepository;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@WebMvcTest(PdvResource.class)
public class PdvResourceTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PdvMongoRepository pdvRepository;

	@Test
	public void getPdvNotFound() throws Exception {
		Pdv pdv = null;
		Optional<Pdv> pdvOptional = Optional.ofNullable(pdv);

		when(pdvRepository.findById(anyInt())).thenReturn(pdvOptional);

		this.mockMvc.perform(get("/pdvs/" + anyInt())).andDo(print()).andExpect(status().isNotFound());
	}

	@Test
	public void getPdvById() throws Exception {

		Pdv pdv = getNewPdvDefault();
		String pdvJson = new Gson().toJson(pdv);
		Optional<Pdv> pdvOptional = Optional.ofNullable(pdv);

		when(pdvRepository.findById(anyInt())).thenReturn(pdvOptional);

		this.mockMvc
				.perform(get("/pdvs/{id}", anyInt()).accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().json(pdvJson))
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

	@Test
	public void searchPDVNotFound() throws Exception {
		Pdv pdv = null;

		when(pdvRepository.getPDVByLongitudeAndLatitude(anyDouble(), anyDouble())).thenReturn(pdv);

		this.mockMvc.perform(get("/pdvs/search/?lng={lng}&lat={lat}", anyDouble(), anyDouble())).andDo(print())
				.andExpect(status().isNotFound());
	}

	@Test
	public void searchPDV() throws Exception {
		Pdv pdv = getNewPdvDefault();
		String pdvJson = new Gson().toJson(pdv);

		when(pdvRepository.getPDVByLongitudeAndLatitude(anyDouble(), anyDouble())).thenReturn(pdv);

		this.mockMvc
				.perform(get("/pdvs/search/?lng={lng}&lat={lat}", anyDouble(), anyDouble())
						.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().json(pdvJson))
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

	@Test
	public void savePDV() throws Exception {
		Pdv pdv = getNewPdvDefault();
		Pdv pdvSaved = getNewPdvDefault();
		pdvSaved.setId(123L);

		String pdvJson = new Gson().toJson(pdv);

		when(pdvRepository.save(any(Pdv.class))).thenReturn(pdvSaved);

		this.mockMvc.perform(post("/pdvs").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
				.content(pdvJson)).andDo(print()).andExpect(status().isCreated());
	}

	private Pdv getNewPdvDefault() {
		return new Pdv("Adega da Cerveja - Pinheiros", "Zé da Silva", "1432132123891/0001", getCoverageAreaDefault(),
				getAddressDefault());
	}

	private CoverageArea getCoverageAreaDefault() {
		CoverageArea coverageArea = new CoverageArea();

		List<List<List<List<Double>>>> coordinates = new ArrayList<List<List<List<Double>>>>();

		coverageArea.setCoordinates(coordinates);
		coverageArea.setType("Point");

		return coverageArea;
	}

	private Address getAddressDefault() {
		Address address = new Address();

		List<Double> coordinates = new ArrayList<>(Arrays.asList(new Double(46), new Double(21)));
		address.setCoordinates(coordinates);
		address.setType("Point");

		return address;
	}

//	this.mockMvc.perform(get("/pdvs")).andDo(print()).andExpect(status().isNotFound())
//	.andExpect(content().string(containsString("Hello Mock")));
}
