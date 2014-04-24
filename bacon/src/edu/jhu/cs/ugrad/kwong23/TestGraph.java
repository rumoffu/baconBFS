package edu.jhu.cs.ugrad.kwong23;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class TestGraph {

    Array<String> a;

    @Before
    public void setupArray() throws LengthException {
        a = new SimpleArray<String>(10, "Peter");
    }

    @Test
    public void lengthConsistentForNewArray() {
        assertEquals(10, a.length());
    }

    @Test
    public void newArrayProperlyInitialized() throws IndexException {
        for (int i = 0; i < a.length(); i++) {
            assertEquals("Peter", a.get(i));
        }
    }

    @Test
    public void setPreservesLength() throws IndexException {
        a.set(4, "Paul");
        assertEquals(10, a.length());
    }

    @Test(expected=IndexException.class)
    public void getTriggersIndexException() throws IndexException {
        a.get(-1);
    }

    @Test(expected=LengthException.class)
    public void newTriggersLengthException() throws LengthException {
        Array<String> a = new SimpleArray<String>(-2, "Peter");
    }

}
