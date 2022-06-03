package name.gavin.lessons.lesson2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertArrayEquals;

@RunWith(MockitoJUnitRunner.class)
public class CyclicRotationTest {


    @Test
    public void testSimple() {
        int[] A = {3, 8, 9, 7, 6};
        int K = 3;

        int[] r = solution(A, K);

        assertArrayEquals("Test", new int[]{9, 7, 6, 3, 8}, r);
    }

    private int[] solution(int[] A, int K) {

        if (A.length == 0) return A;

        K = K % A.length;
        if (K==0) return A;

        if (K<0) {
            K += A.length;
        }

        int[] result = new int[A.length];

        for (int i=0; i<A.length; i++) {
            result[(i+K) % A.length] = A[i];
        }

        return result;
    }
}
