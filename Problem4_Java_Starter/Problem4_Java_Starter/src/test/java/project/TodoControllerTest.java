package project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() throws Exception {
        // 테스트마다 기존 할 일을 정리
        var result = mockMvc.perform(get("/api/todos"))
                .andReturn();

        String json = result.getResponse().getContentAsString();

        var todos = new com.fasterxml.jackson.databind.ObjectMapper()
                .readTree(json);

        for (var todo : todos) {
            mockMvc.perform(delete("/api/todos/" + todo.get("id").asLong()));
        }
    }

    @Test
    void TC1_할일이_정상적으로_생성된다() throws Exception {
        mockMvc.perform(post("/api/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"text\":\"새로운 할 일\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text").value("새로운 할 일"));
    }

    @Test
    void TC2_작성된_할일이_조회된다() throws Exception {
        for (int i = 0; i < 3; i++) {
            mockMvc.perform(post("/api/todos")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"text\":\"할 일 " + i + "\"}"));
        }

        mockMvc.perform(get("/api/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].text").value("할 일 0"))
                .andExpect(jsonPath("$[1].text").value("할 일 1"))
                .andExpect(jsonPath("$[2].text").value("할 일 2"));
    }

    @Test
    void TC3_작성된_할일이_삭제된다() throws Exception {
        for (int i = 0; i < 3; i++) {
            mockMvc.perform(post("/api/todos")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"text\":\"할 일 " + i + "\"}"));
        }

        mockMvc.perform(delete("/api/todos/1"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }
}