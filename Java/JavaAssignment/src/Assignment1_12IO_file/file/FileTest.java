package Assignment1_12IO_file.file;

import java.io.*;

public class FileTest {
    public static void main(String[] args) {
       String PATH = "/Users/raymundoortizjr/Documents/JavaAssignment/src/Assignment1_12IO_file/file/file.txt";
        byte[] data = {'Q', 'U', 'A', 'N', 'G'};
         FileOutputStream fileOutputStream = null;
         BufferedOutputStream bufferedOutputStream = null;
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        File file = new File("/Users/raymundoortizjr/Documents/JavaAssignment/src/Assignment1_12IO_file/file/file.txt");
        try {
            fileOutputStream = new FileOutputStream(file, true);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(data);
            bufferedOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileInputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            int c;
            while ((c = bufferedInputStream.read()) != -1){
                System.out.print((char) c);
            }
            bufferedInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
