package Assignment1_12IO_file.file;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
    public static final String PATH = "/Users/raymundoortizjr/Documents/JavaAssignment/src/Assignment1_12IO_file/file/file.txt";
    public static final String COMMA = ", ";
    public static final String RegexPhone = "^[03,09,01,+84][0-9]{9,12}$";
    public static final String RegexEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("SV001", "Nguyen Van Quang", "0397111634", "quang10a30504@gmail.com"));
        studentList.add(new Student("SV002", "Duong Thi Thuy", "0321987223", "thuy806@gmail.com"));
        studentList.add(new Student("SV003", "Nguyen Van Hung", "035432123", "vanhung123@gmail.com"));
        studentList.add(new Student("SV004", "Nguyen Thi Minh", "0123456789", "minh123@gmail.com"));
        studentList.add(new Student("SV005", "Tran Minh Duong", "0397961099", "duongtm123@gmail.com"));

        // write list Student in file
        List<String> lines = new ArrayList<>();
        for (int i = 0 ; i<studentList.size();i++){
            String line = studentList.get(i).getMSSV() + COMMA + studentList.get(i).getName() + COMMA + studentList.get(i).getPhone() +COMMA + studentList.get(i).getEmail();
            lines.add(line);
        }
        IOFile.writeFile(PATH, lines);

        // read list String in file and convert to list Student and check Validate
        List<Student> listReadFile = new ArrayList<>();
        List<String> listStudentString = IOFile.fileRead(PATH);

        listStudentString.forEach(System.out::println);
        for (int i = 0 ; i<listStudentString.size();i++){
          listReadFile.add(new Student(listStudentString.get(i).split(",")[0],listStudentString.get(i).split(",")[1], listStudentString.get(i).split(",")[2],listStudentString.get(i).split(",")[3]));

          if (!Pattern.matches(RegexPhone, listStudentString.get(i).split(", ")[2])){
              System.out.println("Line " +i +" sai dinh dang phone ");
          }
          if (!Pattern.matches(RegexEmail, listStudentString.get(i).split(", ")[3])){
              System.out.println("Line " +i +" sai dinh dang email");
          }
        }
//        FileOutputStream file = null;
//        try {
//            file = new FileOutputStream("/Users/raymundoortizjr/Documents/JavaAssignment/src/Assignment1_12IO_file/file/test.txt");
//            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(file);
//            outputStreamWriter.write("ddd");
//            outputStreamWriter.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        FileInputStream file1 = null ;
//        try {
//            file1 = new FileInputStream("/Users/raymundoortizjr/Documents/JavaAssignment/src/Assignment1_12IO_file/file/test.txt");
//            InputStreamReader inputStreamReader = new InputStreamReader(file1);
//            inputStreamReader.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
