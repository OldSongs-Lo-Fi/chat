package server.unity.chat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.MultiValueMap;
import server.unity.chat.ServiceInterface.UserService;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserService userService;

    @Test
    void testRegistration() throws Exception {
        userService.createUser("1111", "vlad", "Dracula");
        mockMvc.perform(MockMvcRequestBuilders.post("/user/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"nickname\": \"Dracula\",\n" +
                                "  \"login\": \"vlad\",\n" +
                                "  \"password\": \"1111\"\n" +
                                "}\n"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void loginTest() throws Exception {
        userService.createUser("1111", "vlad", "Dracula");

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .param("username", "vlad")
                        .param("password", "1111"))
                .andExpect(MockMvcResultMatchers.status().is(302));
    }
}
