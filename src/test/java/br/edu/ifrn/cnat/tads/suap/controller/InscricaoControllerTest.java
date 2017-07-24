package br.edu.ifrn.cnat.tads.suap.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
public class InscricaoControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testandoRespostaParaInscricaoValida() throws Exception {
         this.mockMvc
           .perform(
        		   get("/api/20172014040001/disciplinas/inscricao")
        		   .content("{\n" + 
        		   		"    \"aluno\": 20172014040001,\n" + 
        		   		"    \"disciplinas\": [\n" + 
        		   		"      \"TEC.0015\", \"TEC.0017\",\n" + 
        		   		"      \"TEC.0003\", \"TEC.0018\",\n" + 
        		   		"      \"TEC.0014\", \"TEC.0016\",\n" + 
        		   		"      \"TEC.0022\",\n" + 
        		   		"      \"TEC.0005\"\n" + 
        		   		"    ]\n" + 
        		   		"}")
        		   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
           .andDo(print())
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.estado").value(201))
           .andExpect(jsonPath("$.mensagem").value("Inscrição realizada com sucesso"));
  }
/*
requisição
{
    "aluno": 20172014040001,
    "disciplinas": [
      "TEC.0015", "TEC.0017",
      "TEC.0003", "TEC.0018",
      "TEC.0014", "TEC.0016",
      "TEC.0022",
      "TEC.0005"
    ]
}

respota
{"estado": 201, "mensagem": "Inscrição realizada com sucesso"}
*/

}
