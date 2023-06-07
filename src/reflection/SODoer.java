package reflection;

public class SODoer implements SomeOtherInterface {

    /**
     * Переопределённый метод интерфейса SomeOtherInterface
     */
    @Override
    public void doSomeOther() {
        System.out.print("C");
    }
}
