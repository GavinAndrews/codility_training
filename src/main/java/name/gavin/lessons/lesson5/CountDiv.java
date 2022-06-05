package name.gavin.lessons.lesson5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CountDiv {

    public int solution(int A, int B, int K) {
        int inRange = B / K - Math.max(A - 1, 0) / K;
        // 0/K is a special case so if 0 in range
        if ((Math.min(A,B) <= 0)&&(Math.min(A,B) >= 0)) inRange++;
        return inRange;
    }

    @Test
    public void testSimple() {

        int A = 6;
        int B =  11;
        int K = 2;

        int r = solution(A, B, K);
        assertEquals("Test", 3, r);
    }
}
