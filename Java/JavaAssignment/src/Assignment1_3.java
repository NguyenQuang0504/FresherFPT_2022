import java.util.Scanner;

public class Assignment1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ban hay nhap so n");
        int n = scanner.nextInt();
        double sum = 0;
        for ( int i = 1 ; i< n ; i ++){
                int b = 1 ;
                for (int j = 1; j <= 2*i-1 ; j ++){
                    b *=j;
                }
                sum += 1.0/b;
        }
        System.out.println("Tong la " +sum);
    }
}
