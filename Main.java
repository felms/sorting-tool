import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Long, Integer> numberFrequency = new Hashtable<>();
        Long greatestNumber = Long.MIN_VALUE;
        int countNumbers = 0;

        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            if (numberFrequency.containsKey(number)) {
                int frequency = numberFrequency.get(number);
                frequency++;
                numberFrequency.replace(number, frequency);
            } else {
                numberFrequency.put(number, 1);
            }
            if (number > greatestNumber) {
                greatestNumber = number;
            }
            countNumbers++;
        }

        System.out.printf("Total numbers: %d.\n" +
                "The greatest number: %d (%d time(s)).",
                countNumbers, greatestNumber, numberFrequency.get(greatestNumber));
    }
}
