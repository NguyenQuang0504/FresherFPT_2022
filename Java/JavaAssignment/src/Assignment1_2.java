import java.util.Scanner;

public class Assignment1_2 {
    public static void main(String[] args) {
        /*
        * Tính tổng 1/1 + 1/2+1/3..
        * */
        double sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap n");
        int n = scanner.nextInt();
        for (double i = 1; i <= n ; i ++){
            sum +=(1/i);
        }
        System.out.println("Tong la " +sum );
    }
}
