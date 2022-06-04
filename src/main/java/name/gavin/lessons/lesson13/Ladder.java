package name.gavin.lessons.lesson13;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class Ladder {

    public int[] solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int[] result = new int[A.length];

        int maxValue = Integer.MIN_VALUE;
        for (int i=0; i<A.length; i++) {
            if (A[i] > maxValue) maxValue = A[i];
        }

        int[] fibs = new int[maxValue+1];
        fibs[0] = 1;
        fibs[1] = 1;
        for (int i=2; i<= maxValue; i++) {
            fibs[i] = (fibs[i-1] + fibs[i-2]) % (1<<30);
        }

        for (int i=0; i<A.length; i++) {
            int r = fibs[A[i]];
            result[i] = r % (1<<B[i]);
        }
        return result;
    }

    @Test
    public void testSimple() {

        int[] A = new int[5];
        int[] B = new int[5];

        A[0] = 4;   B[0] = 3;
        A[1] = 4;   B[1] = 2;
        A[2] = 5;   B[2] = 4;
        A[3] = 5;   B[3] = 3;
        A[4] = 1;   B[4] = 1;

        int[] r = solution(A, B);
        assertArrayEquals("Test", new int[]  {5, 1, 8, 0, 1}, r);
    }
}
