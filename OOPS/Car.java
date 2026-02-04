package OOPS;
public class Car {
   private String color;
    private int price;
    private int speed;
    public Car(String color,int price,int speed){
        this.color=color;
        this.price=price;
        this.speed=speed;

    }
    public void displayCar(){
        System.out.println(color);
        System.out.println(price);
        System.out.println(speed);

    }
    
}
