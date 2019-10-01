package com.kakao.Project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kakao.project.controller.TransactionInqController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectApplicationTests {
	
	@Autowired
	TransactionInqController transactionInqController;
	
	@Autowired
	private MockMvc mockMvc;
	
	ObjectMapper om = new ObjectMapper();
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(transactionInqController).build();
	}
	
	@Test
	public void selectOneTest() throws Exception{
		assertThat(mockMvc).isNotNull();
		
		mockMvc.perform(get("/transaction/selectOne"))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void selectTwoTest() throws Exception{
		assertThat(mockMvc).isNotNull();
		
		mockMvc.perform(get("/transaction/selectTwo"))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void selectThreeTest() throws Exception{
		assertThat(mockMvc).isNotNull();
		
		mockMvc.perform(get("/transaction/selectThree"))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void selectFourTest() throws Exception{

		String BrName = "판교점";
		
		mockMvc.perform(get("/transaction/selectFour/"+BrName))
				.andExpect(status().isOk())
				.andDo(print());		
	}
	

}
