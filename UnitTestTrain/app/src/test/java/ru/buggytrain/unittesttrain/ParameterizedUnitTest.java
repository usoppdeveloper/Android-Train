package ru.buggytrain.unittesttrain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Buggy on 23.09.2017.
 */

@RunWith(Parameterized.class)
public class ParameterizedUnitTest {

    int a, b, result;

    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(new Object[][] {
            {2, 2, 4},
            {4, 3, 7},
            {5, 10, 12}
        });
    }

    public ParameterizedUnitTest(int a, int b, int result) {
        this.a = a;
        this.b = b;
        this.result = result;
    }

    @Test
    public void checkAddition() throws Exception {
        System.out.println("checkAddition");
        assertEquals(result, MyMath.sum(a, b));
    }
}
