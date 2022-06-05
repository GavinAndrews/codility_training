package name.gavin.lessons.lesson16;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MaxNonoverlappingSegments {

    public int solution(int[] A, int[] B) {

        if (A.length == 0) return 0;

        // This only works because B[k] <= B[K+1] i.e. our line must end before the later ones...
        // i.e. no multiple lines concealed under this one

        int n = 0;
        int head = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i]>head) {
                head = B[i];
                n++;
            }
        }
        return n;
    }

    boolean isOverlapping(int[] A, int[] B, int i, int j) {
        return ((A[i] <= A[j] && A[j] <= B[i]) || (A[j] <= A[i] && A[i] <= B[j]));
    }

    @Test
    public void testSimple() {

        int[] A = new int[] { 1, 3, 7, 9, 9};
        int[] B = new int[] { 5, 6, 8, 9,10};

        int r = solution(A, B);
        assertEquals("Test", 3, r);
    }

    @Test
    public void testSimple2() {

        int[] A = new int[] { 1, 2, 5, 12, 20};
        int[] B = new int[] { 10, 4, 8, 15, 30};

        int r = solution(A, B);
        assertEquals("Test", 3, r);
    }
}
