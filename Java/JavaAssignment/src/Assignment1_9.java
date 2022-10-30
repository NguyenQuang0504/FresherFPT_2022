import java.util.Scanner;

public class Assignment1_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ban hay nhap hang m: ");
        int m = scanner.nextInt();
        System.out.print("Ban hay nhap so cot n: ");
        int n = scanner.nextInt();
        int[][] Array = new int[m][n];
        for (int i = 0 ; i<m ; i++){
            for (int j = 0 ; j<n ; j++){
                System.out.print("ban hay nhap Array[" +i+"][" +j +"]:" );
                Array[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0 ; i<m ; i++){
            for (int j = 0 ; j<n ; j++){
                System.out.print(Array[i][j] +" ");
            }
            System.out.println("");
        }
        System.out.print("Cac so la boi cua so 3: ");
        for (int j = 0 ; j< n ; j++){
            if (Array[0][j] %3 ==0){
                System.out.print("Array[0][" +j +"]: " + Array[0][j] +" ");
            }
        }
        int[] ArrayMax = new int[m];
        for (int i = 0;i<m;i++){
            int max = Array[i][0];
            for (int j=0;j<n;j++){
                if (Array[i][j] > max){
                    max = Array[i][j];
                }
            }
            ArrayMax[i] = max;
        }
        System.out.println("");
        System.out.print("Cac phan tu lon nhat tren moi hang: ");
        for (int i = 0 ; i< ArrayMax.length;i++){
            System.out.print(ArrayMax[i] +" ");
        }
    }
}
