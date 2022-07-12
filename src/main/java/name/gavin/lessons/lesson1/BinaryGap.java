package name.gavin.lessons.lesson1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BinaryGap {

    public int solution(int N) {

        if (N < 2) return 0;

        int maxRun = 0;
        int currentRun = 0;

        boolean inRun = false;

        while (N > 0) {
            int bit = N & 1;

            if (bit == 1) {
                maxRun = Math.max(maxRun, currentRun);
                inRun = true;
                currentRun = 0;
            } else {
                if (inRun) currentRun++;
            }
            N >>= 1;
        }
        return maxRun;
    }

    @Test
    public void testSimple() {

        int N = 1041;

        int r = solution(N);
        assertEquals("Test", 5, r);
    }


    @Test
    public void testSimple2() {

        int N = 32;

        int r = solution(N);
        assertEquals("Test", 0, r);
    }
}
