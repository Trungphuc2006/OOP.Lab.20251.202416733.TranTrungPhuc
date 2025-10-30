import java.util.*;
public class Ex64 {
    private static final Map<String, Integer> monthMap = new HashMap<>();
    private static final int[] daysInMonthCommon = {
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };
    static {
        monthMap.put("january", 1);
        monthMap.put("jan", 1);
        monthMap.put("jan.", 1);
        monthMap.put("1", 1);
        monthMap.put("february", 2);
        monthMap.put("feb", 2);
        monthMap.put("feb.", 2);
        monthMap.put("2", 2);
        monthMap.put("march", 3);
        monthMap.put("mar", 3);
        monthMap.put("mar.", 3);
        monthMap.put("3", 3);
        monthMap.put("april", 4);
        monthMap.put("apr", 4);
        monthMap.put("apr.", 4);
        monthMap.put("4", 4);
        monthMap.put("may", 5);
        monthMap.put("may.", 5);
        monthMap.put("5", 5);
        monthMap.put("june", 6);
        monthMap.put("jun", 6);
        monthMap.put("jun.", 6);
        monthMap.put("6", 6);
        monthMap.put("july", 7);
        monthMap.put("jul", 7);
        monthMap.put("jul.", 7);
        monthMap.put("7", 7);
        monthMap.put("august", 8);
        monthMap.put("aug", 8);
        monthMap.put("aug.", 8);
        monthMap.put("8", 8);
        monthMap.put("september", 9);
        monthMap.put("sep", 9);
        monthMap.put("sep.", 9);
        monthMap.put("sept", 9);
        monthMap.put("9", 9);
        monthMap.put("october", 10);
        monthMap.put("oct", 10);
        monthMap.put("oct.", 10);
        monthMap.put("10", 10);
        monthMap.put("november", 11);
        monthMap.put("nov", 11);
        monthMap.put("nov.", 11);
        monthMap.put("11", 11);
        monthMap.put("december", 12);
        monthMap.put("dec", 12);
        monthMap.put("dec.", 12);
        monthMap.put("12", 12);
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter month (name/abbr/number): ");
                String monthInput = scanner.nextLine().trim().toLowerCase();
                Integer monthNumber = monthMap.get(monthInput);              
                if (monthNumber == null) {
                    System.out.println("Invalid month. Please try again.");
                    continue;
                }               
                System.out.print("Enter year (non-negative number): ");
                String yearInput = scanner.nextLine().trim();                
                if (!yearInput.matches("\\d+")) {  // Accept any digits (no minus sign)
                    System.out.println("Invalid year. Please enter a non-negative number.");
                    continue;
                }
                int year = Integer.parseInt(yearInput);
                int days = daysInMonth(monthNumber, year);
                System.out.printf("Number of days in %s %d: %d days\n", capitalize(monthInput), year, days);
                break;
            }
        }
    }
    private static int daysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonthCommon[month - 1];
    }
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    private static String capitalize(String input) {
        if (input.length() == 0) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
