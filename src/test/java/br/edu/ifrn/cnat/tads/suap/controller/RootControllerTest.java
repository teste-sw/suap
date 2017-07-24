package br.edu.ifrn.cnat.tads.suap.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RootControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testandoRespostaRoot() throws Exception {
        this.mockMvc
          .perform(get("/"))
          .andDo(print())
          .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.name").value("suap"))
          .andExpect(jsonPath("$.status").value("online"));
  }
}
