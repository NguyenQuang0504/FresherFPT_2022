package Assignment1_12IO_file.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFileStream {
    public static void writeFile(String path, List<Student> student){
        File file = new File(path);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file, true);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Student> readFile(String path){
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        File file = new File(path);
        List<Student> list = new ArrayList<>();
        try {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            if (file.length() >0){
                list = (List<Student>) objectInputStream.readObject();
            }
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
