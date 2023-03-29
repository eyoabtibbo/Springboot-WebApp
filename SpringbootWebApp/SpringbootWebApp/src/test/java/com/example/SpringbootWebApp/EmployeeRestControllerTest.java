package com.example.SpringbootWebApp;

import net.minidev.json.JSONArray;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
class EmployeeRestControllerTest {

    private static MockMvc mockMvc;
  @InjectMocks
    private static EmployeeRestController employeeRestController;


    @BeforeAll
    public void setUp() throws Exception {
        //this creates a mock of employeeRestController
        mockMvc = MockMvcBuilders.standaloneSetup(employeeRestController)
                .build();
    }

    @Test
    public void testSuccessEmployeeWithId() throws Exception {

        mockMvc.perform(get("/employee/listEmployees/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"firstName\":\"Rob\",\"lastName\":\"Moore\",\"id\":200022,\"address\":\"44597 A Avenue, Edmonton, Alberta\"}"));
    }
    @Test
    public void testSuccessEmployeeList() throws Exception {
        mockMvc.perform(get("/employee/listEmployees"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .json(JSONArray.toJSONString(Arrays.asList(EmployeeRestController.employees))

                        ));
    }

}

