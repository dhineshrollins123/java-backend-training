package CarDriver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Car car1 = (Car) context.getBean("dhinesh");
        car1.setSpeed(100);
        Class<Car> cls = Car.class;
        Car car2 = context.getBean(cls);
        System.out.println("Car Speed is " + car2.getSpeed());
    }
}
