package packageTestInstanceof;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Animal animal = dog; // UpCasting
        animal.voic();
        dog.voic();
        if (animal instanceof Dog) {
            System.out.println("True");
            Dog dog1 = (Dog) animal; // DownCasting
            dog1.voic();
        }
        String s1 = "ABCD";
        StringBuffer s2 = new StringBuffer(s1);
        s1.toLowerCase(Locale.ROOT); // chỉ chuyển s1 thành ký tự thường trong dòng code này thoi, ko thay đổi luôn s1
        s1.replace("A","F"); // Giống trên chỉ thay thế ký tự A của s1 thành F trong dòng code này thoi
        System.out.println(s1); // s1 vẫn là ABCD
//        Hàm substring(a,b) là lấy ký tự trong chuỗi String thuộc vị trí a đến b
//        Hàm substring(a) là lấy ký tự trong chuỗi bắt đầu từ vị trí a
        System.out.println(s1.substring(1,2) + s1.substring(2));
        System.out.println(s2.equals(s1) +", " +s1.equals(s2));
    }
}
