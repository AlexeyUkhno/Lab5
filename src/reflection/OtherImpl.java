package reflection;

public class OtherImpl implements SomeInterface {

    /**
     * Переопределённый метод интерфейса SomeInterface
     */
    @Override
    public void doSome() {
        System.out.print("B");
    }
}
