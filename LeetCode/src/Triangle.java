import java.time.temporal.Temporal;

public class Triangle extends Shape {
    public void GetArea(double s,double h){
        this.setS(s*h/2);
    }



}

    public static void main(String args[]){
        Circle circle = new Circle();
        circle.GetArea(8.0);
        System.out.println(circle.getS());


        Rectangle rectangle = new Rectangle();
        rectangle.GetArea(8.0,7.0);
        System.out.println(rectangle.getS());

        Triangle triangle = new Triangle();
        triangle.GetArea(6.0,2.0);
        System.out.println(rectangle.getS());

    }