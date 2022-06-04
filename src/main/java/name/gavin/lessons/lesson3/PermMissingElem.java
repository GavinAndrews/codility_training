package name.gavin.lessons.lesson3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PermMissingElem {

    public int solution(int[] A) {

        if (A.length == 0) return 1;

        long sum = 0;
        long expectedSum = A.length+1;

        for (int i=0; i<A.length; i++) {
            sum += A[i];
            expectedSum += (i+1);
        }

        return (int)(expectedSum-sum);
    }


    @Test
    public void testSimple() {

        int[] A = new int[4];
        A[0] = 2;
        A[1] = 3;
        A[2] = 1;
        A[3] = 5;

        int r = solution(A);
        assertEquals("Test", 4, r);
    }

}
