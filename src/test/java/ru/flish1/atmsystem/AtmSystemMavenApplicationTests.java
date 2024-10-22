package ru.flish1.atmsystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.flish1.atmsystem.service.UserService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AtmSystemMavenApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        assertNotNull(userService);
    }

}
