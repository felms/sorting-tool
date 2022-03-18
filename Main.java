import java.util.*;

public class Main {

    private static Scanner scanner;
    public static void main(final String[] args) {
        scanner = new Scanner(System.in);

        String datatype; 

        if (args.length == 2) {
            datatype = args[1];
        } else {
            datatype = "word";
        }

        switch(datatype) {
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


        scanner.close();
    }

    private static void readLongs() {
        List<Long> numbers = new ArrayList<>();
        Long greatestNumber = Long.MIN_VALUE;
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
