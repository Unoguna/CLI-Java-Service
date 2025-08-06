package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AppTest {

    @Test
    @DisplayName("명령어 입력")
    public void t1 () {
        String rs = AppTestRunner.run("");
        assertThat(rs)
                .contains("명령어: ");
    }
}
