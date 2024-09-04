import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class TortoiseHareRaceTest {
    InputStream in = null;
    PrintStream out = null;

    InputStream inputStream = null;
    OutputStream outputStream = null;

    @Before
    public void setUp() {
        in = System.in;
        out = System.out;

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

    }

    @After
    public void tearDown() {
        System.setIn(in);
        System.setOut(out);
    }

    @Test
    public void test1() {
        check(5, 79, 1, 100, "Hare Win!");
    }

    @Test
    public void test2(){
        check(5,80,1,100,"Draw!");
    }

    @Test
    public void test3(){
        check(5,81,1,100,"Tortoise Win!");
    }

    @Test
    public void test4(){
        check(5,30,2,99,"Tortoise Win!");
    }

    private void check(int hareSpeed, int hareSleepDuration, int tortoiseSpeed, int distance, String expected) {

        TortoiseHareRace thr = new TortoiseHareRace();
        thr.game(hareSpeed, hareSleepDuration, tortoiseSpeed, distance);

        String output = outputStream.toString();

        assertEquals(expected, output);

    }

}
