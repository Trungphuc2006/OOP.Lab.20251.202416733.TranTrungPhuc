package hust.soict.dsai.garbage;
import java.nio.file.*;
import java.io.IOException;
public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "largefile.txt";  
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char) b;
            }
            endTime = System.currentTimeMillis();
            System.out.println("Execution time (GarbageCreator): " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
