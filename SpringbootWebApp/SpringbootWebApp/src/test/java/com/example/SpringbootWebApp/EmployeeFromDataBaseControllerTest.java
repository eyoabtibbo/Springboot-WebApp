package com.example.SpringbootWebApp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeRestController.class)
@ExtendWith(SpringExtension.class)
class EmployeeFromDataBaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

  @MockBean
    public EmployeeBusinessService businessService;


  @Test
  public void testSuccessEmployeeListFromDB() throws Exception {

      when(businessService.addUsernameForAllEmployees()).thenReturn(
              Arrays.asList(new Employee("Joshua", "Smith", 100021, "908 Robie St., Halifax, Nova Scotia")));

      RequestBuilder request = MockMvcRequestBuilders
              .get("/employee/employee-in-database")
              .accept(MediaType.APPLICATION_JSON);

      MvcResult result = mockMvc.perform(request)
              .andExpect(status().isOk())
              .andExpect(content().json("[{\"firstName\":\"Joshua\",\"lastName\":\"Smith\",\"id\":100021,\"address\":\"908 Robie St., Halifax, Nova Scotia\",\"username\": \"JoshuaSmith\"}]"))
              .andReturn();
    }

}

