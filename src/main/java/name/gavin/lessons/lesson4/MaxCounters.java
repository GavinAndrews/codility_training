package name.gavin.lessons.lesson4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertArrayEquals;

@RunWith(MockitoJUnitRunner.class)
public class MaxCounters {

    public int[] solution(int N, int[] A) {
        int[] r = new int[N];

        int maxSum = 0;
        int highWaterMark = 0;
        for (int a : A) {
            if (a < (N + 1)) {
                int s = r[a - 1];
                s = Integer.max(s, highWaterMark);
                s++;
                r[a - 1] = s;
                maxSum = Integer.max(s, maxSum);
            } else {
                highWaterMark = maxSum;
            }
        }

        // Make sure highWaterMark applied
        for (int i=0; i<N; i++) {
            r[i] = Integer.max(highWaterMark, r[i]);
        }

        return r;
    }

    @Test
    public void testSimple() {

        int N = 5;

        int[] A = new int[7];
        A[0] = 3;
        A[1] = 4;
        A[2] = 4;
        A[3] = 6;
        A[4] = 1;
        A[5] = 4;
        A[6] = 4;

        int[] r = solution(N, A);
        assertArrayEquals("Test", new int[]{3, 2, 2, 4, 2}, r);
    }
}
