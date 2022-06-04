package name.gavin.lessons.lesson6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MaxProductOfThree {


    public int solution(int[] A) {

        if (A.length < 3) return 0;

        Arrays.sort(A);

        int v1 = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
        int v2 = A[0] * A[1] * A[A.length - 1];  // -ve * -ve * +ve
        return Integer.max(v1, v2);
    }


    @Test
    public void testSimple() {

        int[] A = new int[6];

        A[0] = -3;
        A[1] = 1;
        A[2] = 2;
        A[3] = -2;
        A[4] = 5;
        A[5] = 6;

        int r = solution(A);
        assertEquals("Test", 60, r);
    }


}
