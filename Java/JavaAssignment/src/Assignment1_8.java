import java.sql.Array;
import java.util.Scanner;

public class Assignment1_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ban hay nhap so phan tu mang A: ");
        int n = scanner.nextInt();
        int[] Array = new int[n];
        for (int i = 0 ; i< n ; i++){
            System.out.print("Ban hay nhap phan tu A[" +i +"]: ");
            Array[i] = scanner.nextInt();
        }
        System.out.print("Ban hay nhap phan tu k de kiem tra: ");
        int k = scanner.nextInt();
        int sum = 0;
        boolean check = true;
        for (int i = 0; i<Array.length; i++){
            if (Array[i] == k){
                check = false;
                System.out.println("Phan tu k xuat hien tai vi tri thu: " +(i+1));
            }
            if (Array[i]%2!=0 && Array[i]>0){
                sum += Array[i];
            }
        }
        if (check){
            System.out.println("Phan tu " +k + " khong co trong mang A");
        }
        System.out.println("Tong cac phan tu le cua mang A la: " +sum);

        int min = 0;
        for (int i = 0;i< Array.length;i++){
            for (int j = i+1; j< Array.length ; j++){
                if (Array[j] < Array[i]){
                    int a = Array[i];
                    Array[i] = Array[j];
                    Array[j] = a;
                }
            }
        }
        System.out.print("Cac phan tu cua mang la: ");
        for (int i = 0 ; i< Array.length;i++){
            System.out.print(Array[i] + " ");
        }

        System.out.print("Ban hay nhap so muon chen vao mang A:");
        int a = scanner.nextInt();
        int[] Array2 = new int[Array.length+1];
        for (int i =0 ; i<Array.length;i++){
           if (Array[i]<a){
               Array2[i] =Array[i];
           }
           else {
               Array2[i] = a;
               for (int j=i+1 ;j<Array2.length;j++){
                   Array2[j] = Array[j-1];
               }
               break;
           }
        }
        System.out.println("Mang sau khi them vao: ");
        for (int i = 0 ; i<Array2.length ; i++){
            System.out.print(Array2[i] +" ");
        }
    }
}
