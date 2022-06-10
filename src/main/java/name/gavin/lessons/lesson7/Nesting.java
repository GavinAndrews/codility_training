package name.gavin.lessons.lesson7;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class Nesting {

    public int solution(String S) {

        // Empty String considered good
        if (S.length() == 0) return 1;

        int depth = 0;

        for (int i=0; i<S.length(); i++) {
            char c = S.charAt(i);

            if (c == '(') {
                depth++;
            } else
            {
                if (depth == 0) return 0;
                depth--;
            }
        }
        return (depth == 0) ? 1 : 0;
    }


    @Test
    public void testSimple() {

        String S = "(()(())())";

        int r = solution(S);
        assertEquals("Test", 1, r);
    }

    @Test
    public void testSimple2() {

        String S = "())";

        int r = solution(S);
        assertEquals("Test", 0, r);
    }
}
