package name.gavin.lessons.lesson12;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ChocolatesByNumbers {

    public int solution(int N, int M) {
        // write your code in Java SE 8
        return N/gcd(N,M);
    }

    public int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    @Test
    public void testSimple() {

        int N=10;
        int M=4;
        int r = solution(N,M);
        assertEquals("Test", 5, r);
    }
}
