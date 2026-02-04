package OOPS;
public class Car {
   private String color;
     int price;
     int speed;
    public Car(String color,int price,int speed){
        this.color=color;
        this.price=price;
        this.speed=speed;

    }
     public void setColor(String color){
        this.color=color;
    }
    
    public void displayCar(){
        System.out.println(color);
        System.out.println(price);
        System.out.println(speed);

    }
   
}
