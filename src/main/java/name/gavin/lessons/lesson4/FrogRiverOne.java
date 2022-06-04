package name.gavin.lessons.lesson4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FrogRiverOne {

    public int solution(int X, int[] A) {

        if (X<=0) return 0;

        int[] positions = new int[X+1];

        int filled = 0;

        for (int i=0; i<A.length; i++) {
            int l = A[i];
            if ((l<0)||(l>X)) continue;
            if (positions[l] == 0) {
                positions[l] = 1;
                filled++;
            }

            if (filled == X) {
                return i;
            }
        }

        // write your code in Java SE 8
        return -1;
    }

    @Test
    public void testSimple() {

        int[] A = new int[8];
        A[0] = 1;
        A[1] = 3;
        A[2] = 1;
        A[3] = 4;
        A[4] = 2;
        A[5] = 3;
        A[6] = 5;
        A[7] = 4;

        int X = 5;

        int r = solution(X, A);
        assertEquals("Test", 6, r);
    }
}
