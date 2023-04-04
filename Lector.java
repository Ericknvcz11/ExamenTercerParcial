import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lector {
    private static int lines = 0;

    public void ejecutar(int ID) {
    	String strID = Integer.toString(ID);
        int start = Integer.parseInt(strID.substring(3, 6));
        Map<String, Integer> wordCount = new HashMap<>();
        int rowCount = 0;
        lines = start; 
        int rows = lines + 50; 

        try (Scanner scanner = new Scanner(new File("C:\\Users\\erick\\OneDrive\\Documents\\UDLAP\\4to Sem\\ArchivosE.csv"))) {
            while (scanner.hasNextLine() && rowCount < rows) {
                String line = scanner.nextLine();
                System.out.println(line);
                if (rowCount >= start) {
                    System.out.println(line); 
                    String[] words = line.split(",");
                    for (String word : words) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
                rowCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String FileName = ID + ".txt";
        try (FileWriter fw = new FileWriter(FileName)) {
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                String word = entry.getKey();
                int count = entry.getValue();
                fw.write(word + " = " + count + "\n");
                System.out.println(word + " = " + count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(start);
    }
}
