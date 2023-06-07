package lab;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    /**
     * @param args - аргументы Main
     * @throws IOException - предупреждение, что может быть вызвано исключение, которое вызывается когда происходят I/O ошибки.
     * @throws InstantiationException - предупреждение, что может быть вызвано исключение создания экземпляра
     * @throws IllegalAccessException предупреждение, что может быть вызвано исключение при создании экземляра без доступа к определению  класса, поля, метода или конструктора.
     */
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException , InvocationTargetException, NoSuchMethodException {

        SomeBean sb = (new Injector<SomeBean>("src/data/inj.properties").inject(new SomeBean()));
        sb.go();
    }
}