package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;


class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void ����_����() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "���� ����� : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test void �̸���_����_����_ó��() {
    	assertSimpleTest( () -> {
    		runException("pobi,javaji");
    		assertThat(output()).contains(ERROR_MESSAGE); 
    		} 
    	); 
	}

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}