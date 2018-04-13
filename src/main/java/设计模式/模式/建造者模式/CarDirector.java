package 设计模式.模式.建造者模式;
public class CarDirector {
    CarBuilder cb;
    public CarDirector(CarBuilder cb){
        this.cb=cb;
    }
    public Car constructCar(){
        Car car=new Car();
        car.setEngine(cb.buildEngine());
        car.setTyre(cb.buildTyre());
        car.setSeat(cb.buildSeat());
        return car;
    }
}