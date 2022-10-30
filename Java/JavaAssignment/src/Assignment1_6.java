import java.sql.Array;
import java.util.Scanner;

public class Assignment1_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ban hay nhap n");
        String m = "";
        int n = scanner.nextInt();
        while(n!=0){
            int a = n%2;
            m = m+a;
            n = n/2;
        }
        System.out.println(m);
    }
}
