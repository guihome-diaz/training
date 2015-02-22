package eu.daxiongmao.training.codify.lesson05queues;

import org.junit.Assert;
import org.junit.Test;

public class NestingTest {

    @Test
    public void exampleDataTestSuccess() {
        final Nesting algo = new Nesting();

        String testString = "()";
        Assert.assertEquals(1, algo.checkString(testString));

        testString = "(())";
        Assert.assertEquals(1, algo.checkString(testString));

        testString = "(()(())())";
        Assert.assertEquals(1, algo.checkString(testString));
    }

    @Test
    public void exampleDataTestFailure() {
        final Nesting algo = new Nesting();
        String testString = "())";
        Assert.assertEquals(0, algo.checkString(testString));
    }

    @Test
    public void emptyString() {
        final Nesting algo = new Nesting();
        String testString = "";
        Assert.assertEquals(1, algo.checkString(testString));

        testString = null;
        Assert.assertEquals(1, algo.checkString(testString));
    }

    @Test
    public void failureNoOpening() {
        final Nesting algo = new Nesting();
        String testString = "(()()))";
        Assert.assertEquals(0, algo.checkString(testString));
    }

    @Test
    public void failureNoClosure() {
        final Nesting algo = new Nesting();
        String testString = "(()";
        Assert.assertEquals(0, algo.checkString(testString));

        testString = "(()(())";
        Assert.assertEquals(0, algo.checkString(testString));
    }

    @Test
    public void failureText() {
        final Nesting algo = new Nesting();
        String testString = "(U)()";
        Assert.assertEquals(0, algo.checkString(testString));
    }
}
