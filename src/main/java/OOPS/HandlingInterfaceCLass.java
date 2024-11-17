package OOPS;

interface TypesOfTesting {
    void smoke();       // abstract method
    void sanity();      // abstract method
    void regression();  // abstract method
}
//class implements an interface.
class Testing implements TypesOfTesting {
    public void smoke() {
        System.out.println("Smoke Testing");
    }
    public void sanity() {
        System.out.println("Sanity Testing");
    }
    public void regression() {
        System.out.println("Regression Testing");
    }
}
public class HandlingInterfaceCLass {
    public static void main(String[] args) {
        //We can create object reference for interface but we cannot instantiate interface
        TypesOfTesting types = new Testing();
        types.regression();
        types.sanity();
        types.smoke();
    }
}
