package Assignment1_12IO_file.file;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MainStream {
    public final static String PATH = "/Users/raymundoortizjr/Documents/JavaAssignment/src/Assignment1_12IO_file/file/fileStream.csv";
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("SV001", "Nguyen Van Quang", "0397111634", "quang10a30504@gmail.com"));
        studentList.add(new Student("SV002", "Duong Thi Thuy", "0321987223", "thuy806@gmail.com"));
        studentList.add(new Student("SV003", "Nguyen Van Hung", "035432123", "vanhung123@gmail.com"));
        studentList.add(new Student("SV004", "Nguyen Thi Minh", "0123456789", "minh123@gmail.com"));
        studentList.add(new Student("SV005", "Tran Minh Duong", "0397961099", "duongtm123@gmail.com"));
        IOFileStream.writeFile(PATH, studentList);
        List<Student> listStudentRead = IOFileStream.readFile(PATH);
        System.out.println(listStudentRead.size());
        listStudentRead.forEach(System.out::println);
    }
}
