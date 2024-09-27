package com.gsg.paltechlinker.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsg.paltechlinker.TestDataUtil;
import com.gsg.paltechlinker.domain.entities.CompanyEntity;
import com.gsg.paltechlinker.services.CompanyService;


@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CompanyControllerIntegrationTests {
    
    private CompanyService companyService;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Autowired
    public CompanyControllerIntegrationTests(MockMvc mockMvc, CompanyService companyService) {
        this.mockMvc = mockMvc;
        this.companyService = companyService;
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void testThatCreateCompanyReturnsHttpStatus201Created() throws Exception {
        CompanyEntity companyEntity = TestDataUtil.createTestCompanyEntityA();
        companyEntity.setId(null);
        String companyJson = objectMapper.writeValueAsString(companyEntity);
        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/companies/create")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(companyJson)
        ).andExpect(
            MockMvcResultMatchers.status().isCreated()
        );
    }

}
