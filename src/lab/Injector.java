package lab;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Injector <T> {

    private final Properties properties;

    /**
     * Конструктор
     * @param pathToPropertiesFile - путь к файлу.
     * @throws IOException - предупреждение , что метод может вызвать исключение, которое вызывается когда происходят I/O ошибки.
     */
    public Injector(String pathToPropertiesFile) throws IOException {
            properties = new Properties();
            properties.load(new FileInputStream(pathToPropertiesFile));
    }

    /**
     * Функция принимает произвольный объект, проверяет его на наличие полей с AutoInjectable анотацией. Если такое поле есть,
     * то берёт его тип и реализацию в файле .properties.
     * @param obj - объект любого класса
     * @return объект с инициализированными полями (с использованием AutoInjectable)
     */
    public T inject(T obj) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<?> dependency;
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();
        for (Field field: fields) {
            Annotation annotation = field.getAnnotation(AutoInjectable.class);
            if (annotation != null) {
                String[] fieldType = field.getType().toString().split(" ");
                String equalsClassName = properties.getProperty(fieldType[1], null);

                if (equalsClassName != null) {
                    try {
                        dependency = Class.forName(equalsClassName);

                    } catch (ClassNotFoundException e){
                        System.out.println(" Not found class ");
                        continue;
                    }
                    field.setAccessible(true);
                    field.set(obj, dependency.getDeclaredConstructor().newInstance());
                }
                else
                    System.out.println("Not found properties for field type");
            }
        }
        return obj;
    }
}

