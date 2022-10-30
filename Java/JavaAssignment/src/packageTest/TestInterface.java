package packageTest;

public interface TestInterface {

    // accessmodifier phai la public
    void voic();

    // khi khong khai bao accessmodifier thi tu hieu la public
    int add(int a, int b);

    // Access Modifier cua interface thi phai la public

    default void voice2(String message) {
        System.out.println(message);
    }

    private void voic1() {
        System.out.println("Voic");
    }

}
