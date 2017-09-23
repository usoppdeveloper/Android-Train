package ru.buggytrain.unittesttrain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SimpleUnitTest {

    /**
     * This is a common rule for all tests
     */
    @Rule
    public TestRule commonTimeout = new Timeout(100);

    /**
     * This method will run before each tests
     */
    @BeforeClass
    public static void startClass() {
        System.out.println("*** startClass");
    }

    /**
     * This method will run after all tests
     */
    @AfterClass
    public static void endClass() {
        System.out.println("*** endClass");
    }

    /**
     * This method will run before each test
     */
    @Before
    public void start() {
        System.out.println("* start");
    }

    /**
     * This method will run after each test
     */
    @After
    public void end() {
        System.out.println("* end");
    }


    // ----- Tests ---------------------------------------------------------------------------------

    @Test
    public void addition_isCorrect() throws Exception {
        System.out.println("addition_isCorrect");
        assertEquals(4, MyMath.sum(2, 2));
    }

    //@Ignore
    @Test
    public void addition_isNotCorrect() throws Exception {
        System.out.println("addition_isNotCorrect");
        assertEquals(5, MyMath.sum(2, 2));
    }

    @Test(expected = NullPointerException.class)
    public void nullStringTest() {
        System.out.println("hello nullStringTest");
        String str = null;
        assertTrue(str.isEmpty());
    }

    @Test
    public void timeoutTest() throws InterruptedException {
        System.out.println("timeoutTest");
        Thread.sleep(200);
    }
}