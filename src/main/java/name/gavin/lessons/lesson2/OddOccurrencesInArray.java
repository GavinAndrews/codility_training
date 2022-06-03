package name.gavin.lessons.lesson2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class OddOccurrencesInArray {

    public int solution(int[] A) {

        Set<Integer> misMatched = new HashSet();

        for (int i : A) {
            if (misMatched.contains(i)) {
                misMatched.remove(i);
            } else
            {
                misMatched.add(i);
            }
        }

        assert(misMatched.size()==1);

        int r = (int) misMatched.toArray()[0];
        return r;
    }

    @Test
    public void testThing() {

        int[] A = new int[7];

        A[0] = 9;
        A[1] = 3;
        A[2] = 9;
        A[3] = 3;
        A[4] = 9;
        A[5] = 7;
        A[6] = 9;

        int r = solution(A);

        assertEquals("Test", 7, r);


    }
}
