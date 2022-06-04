package name.gavin.lessons;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class Template {

    public int solution(int[] A) {
        return 0;
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
