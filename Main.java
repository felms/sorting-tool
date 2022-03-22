import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Scanner;

public class Main {

    private static Scanner scanner;
    private static String inputType;
    public static void main(final String[] args) {
        scanner = new Scanner(System.in);

        if (args.length > 0) {

            // Testa se a opção '-sortIntegers' está presente
            // caso esteja executa o método adequado
            if (Arrays.asList(args).contains("-sortIntegers")) {
                sortIntegers();
            } else if ("-dataType".equals(args[0])){
                inputType = args[1];
                statsForDatatypes();
            }

        } else {
            inputType = "word";
            statsForDatatypes();
        }

        scanner.close();
    }

    private static void statsForDatatypes() {

        switch(inputType) {
            case "long":
                readLongs();
                break;
            case "line":
                readLines();
                break;
            case "word":
                readWords();
                break;
        }
    }

    private static void sortIntegers() {
        List<Long> numbers = new ArrayList<>();
        while (scanner.hasNext()) {
            long number = scanner.nextLong();
            numbers.add(number);
        }

        numbers.sort(Long::compare);
        StringBuilder res = new StringBuilder();
        numbers.forEach(number -> res.append(number).append(" "));

        System.out.println("Total numbers: " + numbers.size() + ".\n" +
                "Sorted data: " + res);
    }

    private static void readLongs() {
        List<Long> numbers = new ArrayList<>();
        long greatestNumber = Long.MIN_VALUE;
        int countNumbers = 0;

        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            numbers.add(number);
            if (number > greatestNumber) {
                greatestNumber = number;
            }
            countNumbers++;
        }

        System.out.printf("Total numbers: %d.\n" +
                        "The greatest number: %d ( %d time(s)).",
                countNumbers, greatestNumber, Collections.frequency(numbers, greatestNumber));
    }

    private static void readLines() {
        List<String> lines = new ArrayList<>();
        String  longestLine = "";
        int countLines = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
            if (line.length() > longestLine.length()) {
                longestLine = line;
            }
            countLines++;
        }

        int frequency = Collections.frequency(lines, longestLine);

        int percentage = (int) (((double) frequency / (double)countLines) * 100);
        System.out.println("Total lines: " + countLines + ".\n" +
                "The longest line:\n" +
                longestLine + "\n" +
                "(" + frequency + " time(s), " +
                percentage + "%).");
    }

    private static void readWords() {
        List<String> words = new ArrayList<>();
        String  longestWord = "";
        int countWords = 0;

        while (scanner.hasNext()) {
            String word = scanner.next();
            words.add(word);
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
            countWords++;
        }

        int frequency = Collections.frequency(words, longestWord);

        int percentage = (int)(((double) frequency / (double) countWords) * 100);
        System.out.println("Total words: " + countWords + ".\n" +
                "The longest word: " + longestWord + " (" + frequency + " time(s), " +
                percentage + "%).");
    }
}
