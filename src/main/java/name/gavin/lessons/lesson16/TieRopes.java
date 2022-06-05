package name.gavin.lessons.lesson16;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TieRopes {

    public int solution(int K, int[] A)
    {
        int n = 0;
        int currentLength = 0;

        for (int i=0; i<A.length; i++) {
            currentLength += A[i];
            if (currentLength >= K) {
                currentLength = 0;
                n++;
            }
        }
        return n;
    }

    @Test
    public void testSimple() {

        int K=4;
        int[] A = new int[7];
        A[0] = 1;
        A[1] = 2;
        A[2] = 3;
        A[3] = 4;
        A[4] = 1;
        A[5] = 1;
        A[6] = 3;

        int r = solution(K, A);
        assertEquals("Test", 3, r);
    }

    @Test
    public void testSimple2() {

        int K=4;
        int[] A = new int[1];
        A[0] = 1;

        int r = solution(K, A);
        assertEquals("Test", 0, r);
    }

    @Test
    public void testSimple3() {

        int K=4;
        int[] A = new int[1];
        A[0] = 10;

        int r = solution(K, A);
        assertEquals("Test", 1, r);
    }
}
