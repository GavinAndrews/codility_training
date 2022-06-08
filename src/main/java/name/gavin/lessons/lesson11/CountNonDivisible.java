package name.gavin.lessons.lesson11;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertArrayEquals;

@RunWith(MockitoJUnitRunner.class)
public class CountNonDivisible {


    public int[] solution(int[] A) {

        int[] elements = new int[2 * A.length + 1];
        int[] divisors = new int[2 * A.length + 1];

        // bucket sorting
        for (int a : A) {
            elements[a]++;      // remember how many the number "A[i]" in A
        }

        for (int a : A) {
            // Only calculate once for each distinct a
            if (divisors[a] == 0) {
                calculateDivisors(elements, divisors, a);
            }
        }
        // using array A to set results for not arranging new space
        for (int i = 0; i < A.length; i++) {
            A[i] = A.length - divisors[A[i]];
        }
        return A;
    }

    private void calculateDivisors(int[] elements, int[] divisors, int a) {
        for (int j = 1; j * j <= a; j++) {
            if (a % j == 0) {       // j is a factor of A
                if (a / j == j) {   // j^2 - single factor
                    divisors[a] += elements[j];
                } else if (a / j != j) {
                    divisors[a] += elements[j];         // j and a/j both factors
                    divisors[a] += elements[a / j];
                }
            }
        }
    }

    @Test
    public void testSimple() {

        int[] A = new int[5];
        A[0] = 3;
        A[1] = 1;
        A[2] = 2;
        A[3] = 3;
        A[4] = 6;

        int[] r = solution(A);
        assertArrayEquals("Test", new int[]{2, 4, 3, 2, 0}, r);
    }
}
