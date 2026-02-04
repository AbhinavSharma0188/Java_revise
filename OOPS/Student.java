package OOPS;

public class Student {
    String name;//instance variable 
    int age;//instance variable

    public void printDetails() {
        System.out.println("My name is " + name + " and age is " + age);
    }
    public void SayHI(String name){
        System.out.println(name+"Says hi to "+this.name);
    }
}
