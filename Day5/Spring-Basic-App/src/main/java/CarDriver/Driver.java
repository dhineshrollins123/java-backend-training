package CarDriver;


public class Driver {

    //    private final Car car;

    /*public Driver(Car car) { // constructorInjection
        this.car = car;
    }*/

    private Car car;

    public void setCar(Car car) { // setterInjection
        this.car = car;
    }
}