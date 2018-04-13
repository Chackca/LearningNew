package 设计模式.模式.建造者模式;
public class Client {

    public static void main(String[] args) {
        CarDirector carDirector=new CarDirector(new CarBuilder());
        Car car=carDirector.constructCar();
        System.out.println(car.getEngine()+car.getTyre()+car.getSeat());

    }
}