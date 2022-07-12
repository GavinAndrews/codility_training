package name.gavin.lessons.lesson15;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CountDistinctSlices {

    public int solution(int M, int[] A) {

        if (A.length == 0) return 0;
        if (A.length == 1) return 1;


        int[] count = new int[M+1];  // elements range 0...M
        int head = 0;
        int tail = 0;
        int found = 1;

        count[A[0]]++;

        do {
            // Advance Head if possible...
            if (head < A.length-1) {
                if (count[A[head+1]]<1) {
                    head++;
                    count[A[head]]++;
                    found++;
                    continue;
                }
            }

            count[A[tail]]--;
            tail++;


        } while ((tail != head)||(tail != A.length-1));

        return found;

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

        int M = 100000;

        int[] A = new int[2];
        A[0] = 1;
        A[1] = 1;

        int r = solution(M, A);
        assertEquals("Test", 9, r);
    }
}
