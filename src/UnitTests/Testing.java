package UnitTests;
import lab.Injector; import reflection.SomeImpl; import reflection.OtherImpl; import lab.SomeBean;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;

/**
 * Класс с Unit-тестами
 */
public class Testing {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }
    @Test
    public void test1() {

        SomeImpl si = new SomeImpl();
        si.doSome();
        Assertions.assertEquals("A", output.toString(), "Incorrect symbol");
    }
    @Test
    public void test2() {

        OtherImpl oi = new OtherImpl();
        oi.doSome();
        Assertions.assertEquals("B", output.toString(), "Incorrect symbol");
    }
    @Test
    public void test3() throws IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        SomeBean sb = (new Injector<SomeBean>("src/data/inj.properties").inject(new SomeBean()));
        sb.go();
        Assertions.assertEquals("BC", output.toString(), "Incorrect symbol");
    }
}
