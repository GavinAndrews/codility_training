package name.gavin.lessons.lesson14;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MinMaxDivision {

    public int solution(int K, int M, int[] A) {

        if (M<1) return 0;

        // Intention here is to do a binary search in space 0..M*n
        int lower = 0;
        int higher = M*A.length;

        while (higher-lower > 0) {
            int guess = (higher - lower) / 2 + lower;

            boolean isDoable = check_doable(A, K, guess);

            if (isDoable) {
                higher = guess;
            }
            else
            {
                lower = guess+1;
            }
        }
        return lower;
    }

    private boolean check_doable(int[] A, int K, int guess) {
        int buckets = 1;
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i]>guess) return false;
            if (A[i] + total <= guess) {
                total += A[i];
            } else {
                total = A[i];
                buckets++;
                if (buckets > K) return false;
            }
        }
        return true;
    }

    @Test
    public void testSimple() {

        int K = 3;
        int M = 5;
        int[] A = new int[7];
        A[0] = 2;
        A[1] = 1;
        A[2] = 5;
        A[3] = 1;
        A[4] = 2;
        A[5] = 2;
        A[6] = 2;

        int r = solution(K, M, A);
        assertEquals("Test", 6, r);
    }

    @Test
    public void testSimple2() {

        int K = 3;
        int M = 5;
        int[] A = new int[2];
        A[0] = 5;
        A[1] = 3;

        int r = solution(K, M, A);
        assertEquals("Test", 5, r);
    }
}
