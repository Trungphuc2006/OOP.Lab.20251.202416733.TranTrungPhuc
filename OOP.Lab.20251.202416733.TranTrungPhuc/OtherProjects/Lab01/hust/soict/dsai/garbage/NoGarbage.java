package hust.soict.dsai.garbage;
import java.nio.file.*;
import java.io.IOException;
public class NoGarbage {
    public static void main(String[] args) {
        String filename = "answers.txt";  
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            StringBuilder outputStringBuilder = new StringBuilder();
            for (byte b : inputBytes) {
                outputStringBuilder.append((char)b);
            }
            endTime = System.currentTimeMillis();
            System.out.println("Execution time NoGarbage(): " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
