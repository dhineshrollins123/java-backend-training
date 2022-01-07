public class Singleton {
private static Car car;
private Singleton(){

}
public static Car newInstance(){
    if(car==null) return car=new Car();
    return car;
}
}
