package name.gavin.lessons.lesson4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class PermCheck {

    public int solution(int[] A) {
        if (A.length < 1) return 0;

        if (A.length == 1) return A[0] == 1 ? 1 : 0;

        Set<Integer> found = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            int v = A[i];
            if (v < 1 || v > A.length) return 0;
            if (found.contains(v)) return 0;
            found.add(v);
        }
        return 1;
    }

    @Test
    public void testSimple() {

        int[] A = new int[4];
        A[0] = 4;
        A[1] = 1;
        A[2] = 3;
        A[3] = 2;

        int r = solution(A);
        assertEquals("Test", 1, r);
    }
}