package com.br.natixis.natixisbackend.controller;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.br.natixis.natixisbackend.NatixisBackendApplicationTests;
import com.br.natixis.natixisbackend.model.Produto;


public class ProdutoRestApiTest extends NatixisBackendApplicationTests{
	
	private MockMvc mockMvc;
	
	@Autowired
	private ProdutoRestApi produtoRestApi;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(produtoRestApi).build();
	}
	
	@Test
	public void testeAtualizar() throws Exception {
		Produto p = new Produto("Alexandre",new BigDecimal(0));
		String id = "5de97f940ed96d2bd83112f8";
		this.mockMvc.perform(MockMvcRequestBuilders.put("api/produtos/alterar/" + id)).andExpect(MockMvcResultMatchers.redirectedUrl(null));
	}
	
	@Test
	public void testGetById() throws Exception {
		String id = "5de97f940ed96d2bd83112f8";
		this.mockMvc.perform(MockMvcRequestBuilders.put("/api/produtos/buscar/" + id)).andExpect(MockMvcResultMatchers.redirectedUrl(null));
	}
	

	@Test
	public void testeGetAll() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/produtos")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void teste() throws Exception {
		
		Produto p = new Produto("Alexandre",new BigDecimal(0));
		
//		mockMvc.perform(MockMvcRequestBuilders.post("/api/produtos/inserir")
//            .content(p)
//            .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk())
//            .andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	
	@Test
	public void testePost() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/produtos/inserir")
				.param("nome", "Alexandre")
				.param("valor", "50")
				).andExpect(MockMvcResultMatchers.redirectedUrl(null));
	}

}
