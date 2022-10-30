package packageTest;

import Assignment1_12IO_file.file.Student;
import packageTest.ExceptionTest;

import java.io.IOException;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestVariable {
    public static void main(String[] args) {
        
        // Test khai bao String voi 2 cach
        int a = 3;
        int b = 3;
        String a1 = new String("Hello");
        String b1 = new String("Hello");
        System.out.println(a == b);
        System.out.println(a1.equals(b1));
        System.out.println(a1 == b1);


        // Test input with System.in.read()
        try {
            int ch;
            System.out.println("Enter some text: ");
            while ((ch = System.in.read()) != '\n') {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//      Test Emum
        enum variableEnum {
            one,
            two,
            three
        }
        System.out.println(variableEnum.two);
        for (int i = 0; i < variableEnum.values().length; i++) {
            System.out.println(variableEnum.values()[i]);
        }

        // Test String and by pass value and by pass refrence
        String a2 = new String("Hello");
        String a3 = new String("Hello");
        System.out.println(a2.hashCode());
        System.out.println(a3.hashCode());
        System.out.println(a2 == a3);
        System.out.println(a2);
        Student student = new Student("1qqq", "Nguyen Van Quang", "0397111634", "quang@gmail.com");
        Student student2 = new Student("1qqq", "Nguyen Van An", "0397111634", "quang@gmail.com");
        Student student3 = new Student("1qqq", "Nguyen Van Quang", "0397111634", "quang@gmail.com");
        Student student4 = new Student("1qqq", "Nguyen Van An", "0397111634", "auang@gmail.com");
        Student student5 = student;
        System.out.println(student == student2);
        System.out.println(student.equals(student2));
        System.out.println(student == student3);
        System.out.println(a2.indexOf('e'));
        System.out.println(a2.charAt(1));
        System.out.println(a2.contains("Hel0"));
        System.out.println(a2.trim());
        char[] arr = a2.toCharArray();
        for (char a5 : arr) {
            System.out.println(a5);
        }
        String string = new String(arr);
        System.out.println(arr instanceof char[]);
        System.out.println(string instanceof String);
        String r = student.toString();
        System.out.println(r);
        System.out.println(r.split(",")[0]);

        // Test String Buffer and String Builder
        StringBuffer a6 = new StringBuffer("aa");
        System.out.println(a6);
        System.out.println(a6.append(1));
        System.out.println(a6);
        System.out.println(a6.charAt(2));

        // Test do thoi gian thuc hien cua StringBuffer va String Builder
        long startTime = System.currentTimeMillis();
        StringBuffer buffer = new StringBuffer("Hello");
        for (int i = 0; i < 100000; i++) {
            buffer.append("Word");
        }
        System.out.println("StringBuffer is: " + (System.currentTimeMillis() - startTime) + "ms");
        startTime = System.currentTimeMillis();
        StringBuilder buider = new StringBuilder("Hello");
        for (int i = 0; i < 100000; i++) {
            buider.append("Word");
        }
        System.out.println("StringBuilder is: " + (System.currentTimeMillis() - startTime) + "ms");

        // Sort
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("Xin chao");
        stringList.add("Anh iu em");
        Collections.sort(stringList);
        for (String s : stringList) {
            System.out.println(s);
        }
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(student);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        Collections.sort(studentList);
        for (int i = 0 ; i< studentList.size();i++){
            System.out.println("OK" +studentList.get(i).toString());
        }

        //Sort collection with Comparator
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getName().compareTo(o2.getName()) == 0) {
                    return o1.getEmail().compareTo(o2.getEmail());
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });
        for (Student s : studentList) {
            System.out.println(s);
        }
        Set<String> stringMap = new TreeSet<>();
        stringMap.add("Nguyen Van Quang");
        stringMap.add("Cao Tien Luat");
        stringMap.add("Luong Duy Thach");
        stringMap.add("Nguyen Minh Man");
        for (String s : stringMap) {
            System.out.println(s);
        }

        // Test Java Stream
        // Test method sorted theo 2 thuoc tinh, sap xep tang dan theo ten va neu ten giong nhau thi tang dan theo email
        List<Student> list = studentList.stream()
                .sorted(Comparator.comparing(Student::getName).reversed().thenComparing(Student::getEmail))
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        // Test method filter
        List<Student> listFilter = studentList.stream()
                .filter(studen -> studen.getName() == "Nguyen Van An")
                .collect(Collectors.toList());
        listFilter.forEach(System.out::println);

        //Test mehtod anyMatch()
        Boolean listAnyMatch = studentList.stream()
                .allMatch(student8 -> student8.getName().equals("Nguyen Van Quang"));
        System.out.println(listAnyMatch);

        // Test method max, min
        studentList.stream()
                .max(Comparator.comparing(Student::getName))
                .ifPresent(System.out::println);

        // Test method count()
        int count = (int) studentList.stream()
                .filter(student7 -> student7.getName().equals("Nguyen Van Quang"))
                .limit(1)
                .count();
        System.out.println(count);

        //Test method Map()
        String a5 = null;
        System.out.println(a5);

        // Test Functional
        // functional interface;

        System.out.println(testFunc.apply("Quang"));
        System.out.println(testFuncLamdads.apply("Quang"));
//        use andThen
        System.out.println(testFunc.andThen(testFuncLamdads).apply("Quang"));
        System.out.println(testFuncLamdads.andThen(testFunc).apply("Quang"));
        // use multi func
        System.out.println(testFuncMulti.apply("Quang"));
        System.out.println(testBiFunc.apply("Quang", "Thuy"));
        studentConsumer.accept(student);

        //    Test Exception
        try {
            int div = (4 / 0);
            System.out.println(div);
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }

        try {
            test(0);
        }catch (ArithmeticException e){
            System.out.println("Err xu ly");
        }

        try {
            int testCustomEx = testExCustom();
        } catch (ExceptionTest e) {
            System.out.println(e.getMessage());
        }

        // Test Assertion
        int age = 18;
        assert age>=10: "So khong thoa man";
        System.out.println(age);

        // Test iterator
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

//        Test RegEX find();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ban hay nhap tu can tim kiem: ");
        String testFind = scanner.nextLine();
        Pattern pattern = Pattern.compile(testFind);
        Matcher matcher = pattern.matcher("Nguyen Van Quang");
        boolean matcherFor = matcher.find();
        System.out.println("Tim kiem: " +matcherFor);

        //Test Stack
        Stack<Student> studentStack = new Stack<>();
        for (int i = 0 ; i< studentList.size(); i++){
            studentStack.add(studentList.get(i));
        }
        System.out.println("Size cua stack " +studentStack.size());
        studentStack.forEach(System.out::println);
        System.out.println(studentStack.pop());
        System.out.println("Size cua stack sau khi pop: " +studentStack.size());

        // Test Queue
        Queue<Student> studentQueue = new LinkedList<>();
        for (int i = 0 ; i< studentList.size();i++){
            studentQueue.add(studentList.get(i));
        }
        System.out.println("Danh sach trong Queue");
        studentQueue.forEach(System.out::println);
        System.out.println("Thanh phan dau tien cua Queue " + studentQueue.peek());


        //Test Map
        Map<Integer, Student> studentMap =  new HashMap<>();
        studentMap.put(1, student);
        studentMap.put(2, student2);
        studentMap.put(3, student3);
        studentMap.put(4, student4);
        System.out.println("Danh sach Map: ");
        studentMap.entrySet().forEach(n -> System.out.println(n.getValue()));

        //Test String Buffer
        StringBuffer buff1 = new StringBuffer("ABC"); // tạo ra đối tượng ABC mới trong Heap và tham chiếu buff1 đến
        StringBuffer buff2 = new StringBuffer("ABC"); // tạo ra đối tượng ABC mới trong Heap và tham chiếu buff2 đến
        StringBuffer buff3 = buff2; // gắn tham chiếu của đối tượng buff3 bằng tham chiếu đến đối tượng buff2 -> equals = true
        System.out.println(buff1==buff2);
        System.out.println(buff1.equals(buff2));
        System.out.println(buff1.toString().equals(buff2.toString()));
        System.out.println(buff2==buff3);
        System.out.println(buff2.equals(buff3));

        //Equals 2 student
        System.out.println(student.equals(student3));
        System.out.println(student.toString().equals(student3.toString()));
        System.out.println(student);

        System.out.println("StringBuilder");
        StringBuilder builder1 = new StringBuilder("ABC");
        StringBuilder builder2 = new StringBuilder("ABC");
        System.out.println(builder1 == builder2);
        System.out.println(builder1.equals(builder2));
        System.out.println(builder1.toString().equals(builder2.toString()));
        System.out.println(student.getClass());

//        Map<Integer, Student> map = new HashMap<>();
//        map.put(1, student);
//        map.put(2, student2);
//        map.put(2, student3);
//        map.put(4, student4);
//        for (Map.Entry<Integer, Student> m: map.entrySet()){
//            System.out.println(m.getValue());
//        }
    }

    //Method test throws and throw Exception
    public static void test(int x) throws ArithmeticException{
        if (3/x != 1){
            throw new ArithmeticException("Err");
        }
    }

    public static int testExCustom() throws ExceptionTest {
        System.out.println("Ban hay nhap so a");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if (a==0){
            throw new ExceptionTest("Ban da nhap so 0");
        }
        return a;
    }

    // test functional and lamdads
    public static Function<String, String> testFunc = stringF -> stringF + "Sss";
    //        use Lamdads
    public static Function<String, String> testFuncLamdads = String::toLowerCase;

    public static Function<String, String> testFuncMulti = testFunc.andThen(testFuncLamdads);

    public static BiFunction<String, String, String> testBiFunc = (oneAtt, towAtt) -> oneAtt + " : " + towAtt;

    public static Consumer<Student> studentConsumer = student -> System.out.println(student.getName());

}
