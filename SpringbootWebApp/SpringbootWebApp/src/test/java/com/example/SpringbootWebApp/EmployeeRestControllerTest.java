package com.example.SpringbootWebApp;

import net.minidev.json.JSONArray;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@ExtendWith(TestResultLoggerExtension.class)
class EmployeeRestControllerTest {

    private static MockMvc mockMvc;
  @InjectMocks
    private static EmployeeRestController employeeRestController;


    @BeforeAll
    public void setUp(){
        //this creates a mock of employeeRestController
        mockMvc = MockMvcBuilders.standaloneSetup(employeeRestController)
                .build();
    }

    @Test
    public void testSuccessEmployeeWithId() throws Exception {
        mockMvc.perform(get("/employee/listEmployees/100011"))
                    .andExpect(status().isOk())
                    .andExpect(content().json("{\"firstName\":\"Bobby\",\"lastName\":\"Wills\",\"id\":100011,\"address\":\"3742 White Oak Drive, Weston, Missouri\"}"));
    }
    @Test
    public void testSuccessEmployeeWithFirstName() throws Exception {
        mockMvc.perform(get("/employee/listEmployees/firstname=Bobby"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"firstName\":\"Bobby\",\"lastName\":\"Wills\",\"id\":100011,\"address\":\"3742 White Oak Drive, Weston, Missouri\"}"));
    }
    @Test
    public void testSuccessEmployeeWithLastName() throws Exception {
        mockMvc.perform(get("/employee/listEmployees/lastname=Wills"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"firstName\":\"Bobby\",\"lastName\":\"Wills\",\"id\":100011,\"address\":\"3742 White Oak Drive, Weston, Missouri\"}"));
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

