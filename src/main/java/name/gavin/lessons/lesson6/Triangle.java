package name.gavin.lessons.lesson6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class Triangle {

    public int solution(int[] A) {
        if (A.length < 3) return 0;

        Arrays.sort(A);

        for (int nR = A.length - 1; nR > 1; nR--) {
            int aR = A[nR];

            if (aR <= 0) continue;

            int nP = nR - 2;
            int nQ = nR - 1;

            int aP = A[nP];
            int aQ = A[nQ];

            if ((aP <= 0)||(aQ <= 0)) continue;

            // If a & b big... ensure no sign confusing overflow for a+b
            if ((long)aP + (long)aQ > (long)aR) return 1;
        }

        return 0;
    }

    @Test
    public void testSimple() {

        int[] A = new int[6];
        A[0] = 10;
        A[1] = 2;
        A[2] = 5;
        A[3] = 1;
        A[4] = 8;
        A[5] = 20;

        int r = solution(A);
        assertEquals("Test", 1, r);
    }

    @Test
    public void testSimple2() {

        int[] A = new int[4];
        A[0] = 10;
        A[1] = 50;
        A[2] = 5;
        A[3] = 1;

        int r = solution(A);
        assertEquals("Test", 0, r);
    }
}
