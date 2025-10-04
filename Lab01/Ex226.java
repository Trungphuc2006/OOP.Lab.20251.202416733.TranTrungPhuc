import java.util.Scanner;

public class Ex226 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the type of equation to solve:");
        System.out.println("1. First-degree equation with one variable (ax + b = 0)");
        System.out.println("2. System of first-degree equations with two variables");
        System.out.println("3. Second-degree equation with one variable (ax^2 + bx + c = 0)");
        System.out.print("Enter your choice (1-3): ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                solveFirstDegreeOneVariable(scanner);
                break;
            case 2:
                solveSystemOfTwoEquations(scanner);
                break;
            case 3:
                solveSecondDegreeOneVariable(scanner);
                break;
            default:
                System.out.println("Invalid choice! Please select 1, 2, or 3.");
        }
        scanner.close();
    }
    private static void solveFirstDegreeOneVariable(Scanner scanner) {
        System.out.println("Enter coefficients for ax + b = 0");
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has infinitely many solutions.");
            } else {
                System.out.println("The equation has no solution.");
            }
        } else {
            double x = -b / a;
            System.out.printf("Solution: x = %.2f\n", x);
        }
    }
    private static void solveSystemOfTwoEquations(Scanner scanner) {
        System.out.println("Enter coefficients for the system:");
        System.out.println("a1x + b1y = c1");
        System.out.println("a2x + b2y = c2");
        System.out.print("Enter a1: ");
        double a1 = scanner.nextDouble();
        System.out.print("Enter b1: ");
        double b1 = scanner.nextDouble();
        System.out.print("Enter c1: ");
        double c1 = scanner.nextDouble();
        System.out.print("Enter a2: ");
        double a2 = scanner.nextDouble();
        System.out.print("Enter b2: ");
        double b2 = scanner.nextDouble();
        System.out.print("Enter c2: ");
        double c2 = scanner.nextDouble();
        double D = a1 * b2 - a2 * b1; // Determinant
        double Dx = c1 * b2 - c2 * b1;
        double Dy = a1 * c2 - a2 * c1;
        if (D == 0) {
            if (Dx == 0 && Dy == 0) {
                System.out.println("The system has infinitely many solutions.");
            } else {
                System.out.println("The system has no solution.");
            }
        } else {
            double x = Dx / D;
            double y = Dy / D;
            System.out.printf("Solution: x = %.2f, y = %.2f\n", x, y);
        }
    }
    private static void solveSecondDegreeOneVariable(Scanner scanner) {
        System.out.println("Enter coefficients for ax^2 + bx + c = 0");
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("The equation has infinitely many solutions.");
                } else {
                    System.out.println("The equation has no solution.");
                }
            } else {
                double x = -c / b;
                System.out.printf("The equation becomes linear, solution: x = %.2f\n", x);
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.printf("Two distinct real roots: x1 = %.2f, x2 = %.2f\n", x1, x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.printf("One double root: x = %.2f\n", x);
            } else {
                System.out.println("The equation has no real roots.");
            }
        }
    }
}