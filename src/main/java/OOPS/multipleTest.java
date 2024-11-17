package OOPS;

interface shapes {
    void circle();

    static void rectangle() {
        System.out.println("Static Method for RECTANGLE from Shapes Class");
    }

    default void triangle() {
        System.out.println("Default Method for TRIANGLE from Shapes Class");
    }
}

interface vehicle extends shapes {
    void car();

    default void bike() {
        System.out.println("Default Method for BIKE from vehicle CLass");
    }

    static void auto() {
        System.out.println("Static Method for AUTO from vehicle Class");
    }
}

class shapesAndVehicles implements vehicle {
    public void car() {
        System.out.println("Implementation Method for CAR from shapesAndVehicles Class");
    }

    public void circle() {
        System.out.println("Implementation Method for CIRCLE from shapesAndVehicles Class");
    }
}

public class multipleTest{
    public static void main(String[] args) {
        shapesAndVehicles obj = new shapesAndVehicles();
        obj.bike();
        obj.car();
        obj.circle();
        obj.triangle();

        // for to call static methods we need to call interface
        shapes.rectangle(); //interfaceclass.staticmethod();
        vehicle.auto();     //interfaceclass.staticmethod();

    }

}
