package name.gavin.lessons.lesson8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class Dominator {

    public int solution(int[] A) {

        if (A.length == 0) return -1;
        if (A.length == 1) return 0;

        int stackSize = 0;
        int lastValue = 0;

        for (int j : A) {
            if (stackSize == 0) {
                lastValue = j;
                stackSize++;
            } else {
                if (j == lastValue) {
                    stackSize++;
                } else {
                    stackSize--;
                }
            }
        }

        if (stackSize == 0) return -1;

        int candidate = lastValue;
        int candidate_location = -1;
        int n = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) {
                if (candidate_location == -1) candidate_location = i;
                n++;
            }
        }

        if (n > (A.length / 2)) return candidate_location;
        return -1;
    }

    @Test
    public void testSimple() {

        int[] A = new int[8];
        A[0] = 3;
        A[1] = 4;
        A[2] = 3;
        A[3] = 2;
        A[4] = 3;
        A[5] = -1;
        A[6] = 3;
        A[7] = 3;

        int r = solution(A);
        assertEquals("Test", 3, r);
    }

    @Test
    public void testSimple2() {

        int[] A = new int[3];
        A[0] = 1;
        A[1] = 2;
        A[2] = 1;

        int r = solution(A);
        assertEquals("Test", 0, r);
    }
}
