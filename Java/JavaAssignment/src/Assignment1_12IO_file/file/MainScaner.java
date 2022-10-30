package Assignment1_12IO_file.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainScaner {
    public final static String PATH = "/Users/raymundoortizjr/Documents/JavaAssignment/src/Assignment1_12IO_file/file/file.txt";
    public static void main(String[] args) {
        File file = new File(PATH);
        List<String> list = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                list.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(String c: list){
            System.out.println(c);
        }
    }
}
