import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Assignment1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ban hay nhap so can tinh");
        int number = scanner.nextInt();
        String number1 = (String.valueOf(number));
        System.out.println("So ban nhap la: " +number1);
        int sum = 0;
        int multi = 1;
        for (int i = 0 ; i< number1.length() ; i++){
            sum += Integer.parseInt(String.valueOf(number1.charAt(i)));
            multi *= Integer.parseInt(String.valueOf(number1.charAt(i)));
        }
        System.out.println("Tong " +sum);
        System.out.println("Tich " +multi);
    }
}
