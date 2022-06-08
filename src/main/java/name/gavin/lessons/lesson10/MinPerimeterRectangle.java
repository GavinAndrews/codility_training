package name.gavin.lessons.lesson10;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MinPerimeterRectangle {

    public int solution(int N) {

        int rootN = (int) Math.sqrt(N);
        if (rootN * rootN < N) rootN++;  // Guava rounding scheme

        int minSum = Integer.MAX_VALUE;

        for (int a = 1; a <= rootN; a++) {
            if (N % a == 0) {
                int b = N / a;
                int p = 2 * (a + b);
                if (p < minSum) minSum = p;
            }
        }

        return minSum;
    }

    @Test
    public void testSimple() {

        int N = 30;

        int r = solution(N);
        assertEquals("Test", 22, r);
    }
}
