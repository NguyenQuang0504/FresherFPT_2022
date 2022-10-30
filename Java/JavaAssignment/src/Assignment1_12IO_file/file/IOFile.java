package Assignment1_12IO_file.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
    public static void writeFile(String path, List<String> lines){
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0 ; i< lines.size();i++){
                bufferedWriter.write(lines.get(i));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> fileRead(String path){
        List<String> listLine = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            String line = "";
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine())!= null){
                listLine.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listLine;
    }
}
