package name.gavin.lessons.lesson3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TapeEquilibrium {

    public int solution(int[] A) {

        int[] prefixSum = new int[A.length];

        int sum = 0;
        for (int i=0; i<A.length; i++) {
            prefixSum[i] = sum;
            sum += A[i];
        }

        int bestDiff = Integer.MAX_VALUE;

        // sum is now total of all and prefixSum[n] is the sum of all items BEFORE n
        for (int i=1; i<=(A.length-1); i++)
        {
            int left = prefixSum[i];
            int right = sum - left;
            int diff = Math.abs(left - right);
            if (diff < bestDiff) bestDiff = diff;
        }

        return bestDiff;
    }

    @Test
    public void testSimple() {

        int[] A = new int[5];
        A[0] = 3;
        A[1] = 1;
        A[2] = 2;
        A[3] = 4;
        A[4] = 3;

        int r = solution(A);
        assertEquals("Test", 1, r);
    }
}
