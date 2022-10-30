public class Assignment1_10 {
    String a = "Nguyen Van Quang";
    public void changA(Assignment1_10 a){
        a.a = "Pass-by-Refrence";
    }
    public void changeA(String a){
        a = "Pass by value";
    }
    public void changeArr(int[] a){
        a[0] = 100;
    }
    public void changeB(int a){
        a=100;
    }
    public static void main(String[] args) {
        int b = 1;
        Assignment1_10 a = new Assignment1_10();
        System.out.println(a.a);
        a.changeA(a.a);
        System.out.println(a.a);
        a.changA(a);
        System.out.println(a.a);
        int[] arr = {1,2,3,4};
        System.out.println("A[0] truoc khi goi ham " +arr[0]);
        a.changeArr(arr);
        System.out.println("A[0] sau khi goi ham " +arr[0]);
        System.out.println("b truoc khi goi ham " +b);
        a.changeB(b);
        System.out.println("b sau khi goi ham " +b);
    }
}
