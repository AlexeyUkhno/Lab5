package lab;
import reflection.SomeInterface;
import reflection.SomeOtherInterface;

/**
 * Класс, содержащий 2 аннотации
 */
public class SomeBean {
    @AutoInjectable
    private SomeInterface field1;
    @AutoInjectable
    private SomeOtherInterface field2;

    /**
     * Конструктор
     */
    public SomeBean() {}

    /**
     * Метод, который вызывает методы интерфейса для полей с анотациями.
     */
    public void go(){
        field1.doSome();
        field2.doSomeOther();
    }
}
