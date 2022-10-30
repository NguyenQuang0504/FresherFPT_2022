import java.nio.charset.StandardCharsets;
import java.util.*;

public class Assignment1_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ban hay nhap chuoi String");
        String string = scanner.nextLine();
        System.out.println("Chuoi ban nhap la: " +string);
        byte[] string1 = string.getBytes();
        byte[] string2 = new byte[string1.length];
        for (int i = 0 ; i< string1.length ; i++){
            string2[i] = string1[string1.length-1-i];
        }
        System.out.println("Chuoi sau khi dao nguoc la: " +new String(string2));
        System.out.println("Doi chuoi string sang chu hoa: " +string.toUpperCase(Locale.ROOT));
        System.out.println("Doi chuoi string sang chu thuong: " +string.toLowerCase(Locale.ROOT));

        Set charString = new LinkedHashSet();
        for (int i = 0 ; i < string1.length ; i++){
            charString.add(string.charAt(i));
        }
        for (Object s: charString){
            int count = 0;
            for (int j = 0 ; j< string1.length ; j++){
                if(s.equals(string.charAt(j))){
                    count ++;
                }
            }
            System.out.println("Ky tu " +s +" xuat hien " +count +" lan");
        }
        int m, n;
        do {
            System.out.print("Ban hay nhap m:");
            m = scanner.nextInt();
            System.out.print("Ban hay nhap n:");
            n = scanner.nextInt();
        }
        while(m>string1.length || n> string1.length || n == 0 || m==0 || m>=n);
        String stringCut = "";
        for (int i = m ; i < n ; i++){
            stringCut += string.charAt(i);
        }
        System.out.println("Chuoi cat tu " +m +" den " +n +" la:" +stringCut);
    }
}
