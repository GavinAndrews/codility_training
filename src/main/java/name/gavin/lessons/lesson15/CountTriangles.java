package name.gavin.lessons.lesson15;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CountTriangles {

    public int solution(int[] A) {

        if (A.length<3) return 0;

        // Expensive but worth it?
        Arrays.sort(A);

        int count = 0;

        for (int nR = A.length-1; nR >= 0; nR--) {

            int aR = A[nR];

            int nP = 0;
            int nQ = nR-1;

            while (nP < nQ) {

                int aP = A[nP];
                int aQ = A[nQ];

                if (aQ + aP > aR) {
                    count += nQ - nP;
                    nQ--;
                } else {
                    nP++;
                }
            }
        }

        return count;

    }

    @Test
    public void testSimple() {

        int[] A = new int[6];
        A[0] = 10;
        A[1] = 2;
        A[2] = 5;
        A[3] = 1;
        A[4] = 8;
        A[5] = 12;

        int r = solution(A);
        assertEquals("Test", 4, r);
    }
}
