package IntegerPrograms;

abstract class tesTing {
    void functionalTesting() {
        System.out.println("Functional Testing........");
    }

    abstract void nonFunctionalTesting();

    abstract void whiteBoxTesting();

    abstract void blackBoxTesting();

    abstract void grayBoxTesting();

}

class typesOfTesting extends tesTing {
    void nonFunctionalTesting() {
        System.out.println("Performance Testing");
    }

    void whiteBoxTesting() {
        System.out.println("This Testing will done by Developers");
    }

    void blackBoxTesting() {
        System.out.println("This Testing will done by Test Engineers");
    }

    void grayBoxTesting() {
        System.out.println("This Testing will done by who have knowledge on Both");
    }
}

public class HandlingAbstractClass{
    public static void main(String[] args) {
        tesTing testing = new typesOfTesting();
        testing.blackBoxTesting();
        testing.nonFunctionalTesting();
        testing.functionalTesting();
        testing.grayBoxTesting();
        testing.whiteBoxTesting();

    }
}
