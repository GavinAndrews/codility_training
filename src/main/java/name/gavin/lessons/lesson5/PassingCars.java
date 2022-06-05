package name.gavin.lessons.lesson5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PassingCars {

    public int solution(int[] A) {

        if (A.length < 2) return 0;

        int zero_count = 0;
        int n = 0;
        for (int i=0; i<A.length; i++) {
            if (A[i] == 0) zero_count++;
            if (A[i] == 1) {
                n += zero_count;
                if (n>1000000000) return -1;
            }
        }

        return n;
    }

    @Test
    public void testSimple() {

        int[] A = new int[5];
        A[0] = 0;
        A[1] = 1;
        A[2] = 0;
        A[3] = 1;
        A[4] = 1;

        int r = solution(A);
        assertEquals("Test", 5, r);
    }

    @Test
    public void testSimple2() {

        int[] A = new int[5];
        A[0] = 1;
        A[1] = 0;
        A[2] = 0;
        A[3] = 0;
        A[4] = 0;

        int r = solution(A);
        assertEquals("Test", 5, r);
    }
}
