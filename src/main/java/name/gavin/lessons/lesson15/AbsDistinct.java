package name.gavin.lessons.lesson15;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AbsDistinct {

    public int solution(int[] A) {

        // Edge cases
        if (A.length == 0) return 0;
        if (A.length == 1) return 1;

        int n = 1;
        int head = 0;
        int tail = A.length-1;

        long current = Math.max(Math.abs((long)A[head]), (long)Math.abs(A[tail]));

        boolean done = false;
        while (!done) {

            // Sequeeze the ends
            while (head < tail && Math.abs((long)A[head]) == current) head++;
            while (tail > head && Math.abs((long)A[tail]) == current) tail--;

            long newValue = Math.max(Math.abs((long)A[head]), (long)Math.abs(A[tail]));
            if (newValue != current) {
                n++;
                current = newValue;
            }

            if (head == tail) done = true;
        }
        return n;
    }

    @Test
    public void testSimple() {

        int[] A = new int[6];
        A[0] = -5;
        A[1] = -3;
        A[2] = -1;
        A[3] =  0;
        A[4] =  3;
        A[5] =  6;

        int r = solution(A);
        assertEquals("Test", 5, r);
    }

    @Test
    public void testSimple2() {

        int[] A = new int[6];
        A[0] = 1;
        A[1] = 2;
        A[2] = 3;
        A[3] = 4;
        A[4] = 5;
        A[5] = 6;

        int r = solution(A);
        assertEquals("Test", 6, r);
    }


    @Test
    public void testSimple3() {

        int[] A = new int[6];
        A[0] = 1;
        A[1] = 1;
        A[2] = 1;
        A[3] = 1;
        A[4] = 1;
        A[5] = 1;

        int r = solution(A);
        assertEquals("Test", 1, r);
    }


    @Test
    public void testSimple4() {

        int[] A = new int[4];
        A[0] = -2147483648;
        A[1] = -1;
        A[2] = 0;
        A[3] = 1;

        int r = solution(A);
        assertEquals("Test", 3, r);
    }
}
