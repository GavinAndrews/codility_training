package name.gavin.lessons.lesson10;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CountFactors {

    public int solution(int N) {

        int count = 0;
        int i = 1;

        int limit = (int) Math.sqrt(N);
        // Fix rounding (this is what Guava does)
        if (limit*limit < N) limit++;

        while (i < limit) {
            if ((N % i) == 0) {
                // i is a divisor... implies N/i also a divisor
                count += 2;
            }
            i++;
        }
        if (i * i == N) count++;

        return count;
    }

    @Parameterized.Parameter(0)
    public int expected;

    @Parameterized.Parameter(1)
    public int N;

    @Parameterized.Parameters(name = "{index}: Expected {0} = CountFactors {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { {2, Integer.MAX_VALUE}, { 1, 1 }, { 2, 2 },
                { 2, 11 }, { 8, 24 } });
    }

    @Test
    public void test() {
        assertEquals("Test", expected, solution(N));
    }
}
