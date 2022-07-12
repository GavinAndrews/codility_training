package name.gavin.lessons.lesson15;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CountDistinctSlices {

    public int solution(int M, int[] A) {

        if (A.length < 2) return A.length;

        // Condition... each element of array A is an integer within the range [0..M].
        boolean[] found = new boolean[M+1];

        int total = 0;
        int front = 0;
        for (int back=0; back<A.length; back++) {
            while (front < A.length && validRangeIfIncluding(found, A[front])) {
                extend(found, A[front]);
                front++;
            }
            shrink(found, A[back]);
            total += (front-back);
            if (total >= 1000000000) return 1000000000;
        }

        return total;
    }

    boolean validRangeIfIncluding(boolean[] found, int extra) {
        return !found[extra];
    }

    void extend(boolean[] found, int extra) {
        found[extra] = true;
    }

    void shrink(boolean[] found, int extra) {
        found[extra] = false;
    }

    @Test
    public void testSimple() {

        int M = 6;

        int[] A = new int[5];
        A[0] = 3;
        A[1] = 4;
        A[2] = 5;
        A[3] = 5;
        A[4] = 2;

        int r = solution(M, A);
        assertEquals("Test", 9, r);
    }


    @Test
    public void testSimple2() {

        int M = 1;

        int[] A = new int[5];
        A[0] = 1;
        A[1] = 1;
        A[2] = 1;
        A[3] = 1;
        A[4] = 1;

        int r = solution(M, A);
        assertEquals("Test", 5, r);
    }
}
