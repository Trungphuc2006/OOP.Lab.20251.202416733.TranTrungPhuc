import java.util.Arrays;
import java.util.Scanner;
public class Ex65 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers;
        System.out.println("Choose input method:");
        System.out.println("1. Enter array manually");
        System.out.println("2. Use constant array");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.print("Enter number of elements: ");
            int size = scanner.nextInt();
            numbers = new int[size];
            System.out.println("Enter " + size + " integers:");
            for (int i = 0; i < size; i++) {
                numbers[i] = scanner.nextInt();
            }
        } else {
            numbers = new int[]{1789, 2035, 1899, 1456, 2013,};
            System.out.println("Using constant array: " + Arrays.toString(numbers));
        }
        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = (numbers.length > 0) ? (double) sum / numbers.length : 0;
        System.out.println("Sum: " + sum);
        System.out.printf("Average: %.2f%n", average);
        scanner.close();
    }
}

