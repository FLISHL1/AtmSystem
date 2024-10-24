package ru.flish1.atmsystem.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class HashUtilTest {

    @Test
    void hashTextWithAlgorithmSha256() {
        // Ожидаемый хэш для строки "test" с использованием MD5
        String input = "test";
        String expectedHash = "n4bQgYhMfWWaL+qgxVrQFaO/TxsrC4Is0V1sFbDwCgg="; // Пример ожидаемого значения

        HashUtil hashUtil = new HashUtil("SHA-256");
        String actualHash = hashUtil.hashText(input);
        log.info(actualHash);
        log.info(expectedHash);

        // Сравниваем полученный хэш с ожидаемым
        assertEquals(expectedHash, actualHash);
    }
}