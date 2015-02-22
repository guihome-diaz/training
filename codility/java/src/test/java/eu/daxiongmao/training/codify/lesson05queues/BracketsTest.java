package eu.daxiongmao.training.codify.lesson05queues;


import org.junit.Assert;
import org.junit.Test;

public class BracketsTest {

    @Test
    public void exampleDataTestSuccess() {
        final Brackets algo = new Brackets();

        String testString = "()";
        Assert.assertEquals(1, algo.checkString(testString));

        testString = "[]";
        Assert.assertEquals(1, algo.checkString(testString));

        testString = "{}";
        Assert.assertEquals(1, algo.checkString(testString));

        testString = "{[()()]}";
        Assert.assertEquals(1, algo.checkString(testString));
    }

    @Test
    public void exampleDataTestFailure() {
        final Brackets algo = new Brackets();
        String testString = "([)()]";
        Assert.assertEquals(0, algo.checkString(testString));
    }

    @Test
    public void emptyString() {
        final Brackets algo = new Brackets();
        String testString = "";
        Assert.assertEquals(1, algo.checkString(testString));

        testString = null;
        Assert.assertEquals(1, algo.checkString(testString));
    }

    @Test
    public void successCases() {
        final Brackets algo = new Brackets();
        String testString = "{[()()][]()}";
        Assert.assertEquals(1, algo.checkString(testString));

        testString = "({[]})";
        Assert.assertEquals(1, algo.checkString(testString));
    }


    @Test
    public void failureNoOpening() {
        final Brackets algo = new Brackets();
        String testString = "[()()][]()}";
        Assert.assertEquals(0, algo.checkString(testString));

        testString = "({]})";
        Assert.assertEquals(0, algo.checkString(testString));
    }

    @Test
    public void failureNoClosure() {
        final Brackets algo = new Brackets();
        String testString = "{[()()][]()";
        Assert.assertEquals(0, algo.checkString(testString));

        testString = "({[])";
        Assert.assertEquals(0, algo.checkString(testString));
    }

    @Test
    public void failureText() {
        final Brackets algo = new Brackets();
        String testString = "[(U)()]";
        Assert.assertEquals(0, algo.checkString(testString));
    }
}
