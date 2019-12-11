package com.br.natixis.natixisbackend;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.br.natixis.natixisbackend.controller.ProdutoRestApi;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NatixisBackendApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	private MockMvc mockMvc;
	
	@Autowired
	private ProdutoRestApi produtoRestApi;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(produtoRestApi).build();
	}

}
