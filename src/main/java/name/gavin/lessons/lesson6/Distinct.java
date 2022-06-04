package name.gavin.lessons.lesson6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class Distinct {


    public int solution(int[] A) {

        if (A.length == 0) return 0;

        Set<Integer> items = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            int v = A[i];
            items.add(v);
        }

        return items.size();
    }


    @Test
    public void testSimple() {

        int[] A = new int[6];

        A[0] = 2;
        A[1] = 1;
        A[2] = 1;
        A[3] = 2;
        A[4] = 3;
        A[5] = 1;

        int r = solution(A);
        assertEquals("Test", 3, r);
    }


}
