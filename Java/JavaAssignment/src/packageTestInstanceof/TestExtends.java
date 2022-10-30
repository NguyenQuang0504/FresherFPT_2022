package packageTestInstanceof;

import Assignment1_12IO_file.file.Student;

public class TestExtends {
    void m1(TestExtends testExtends){
        System.out.println("TestExtends");
    }
}
class B extends TestExtends{
    void m1(B b){
        System.out.println("B");
    }
}

class C extends B{
    void m1(C c){
        System.out.println("C");
    }
}
class D extends C{
    static void s1(String s){
        s.replace("A", "B");
        System.out.println(s);
    }
    static void s2(String s){
        s = s.replace("A", "B");
        System.out.println(s);
    }
    void m1(D d){
        System.out.println("D");
    }
    public static void main(String[] args) {
        // Test string
        String s = "A";
        s1(s); // Gọi phương thức s1 thì sẽ in ra A
        s2(s); // Gọi phương thức s2 thì sẽ thay đổi s đưa vào thành B và in ra B chứ k liên quan đến s bên ngoài
        System.out.println(s); // In ra s là A

        // Test extends
        TestExtends testExtends = new TestExtends();
        B b = new B();
        C  c = new C();
        c.m1(c);
        b.m1(b);
        System.out.println(c instanceof C);
        Student student = new Student();
        Student student1 = new Student();
        System.out.println(student.equals(student1));
    }
}
