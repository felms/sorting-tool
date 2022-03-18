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
                "The greatest number: %d ( %d time(s)).",
                countNumbers, greatestNumber, numberFrequency.get(greatestNumber));
    }

    private static void readLines() {
        Map<String, Integer> lineFrequency = new Hashtable<>();
        String  longestLine = "";
        int countLines = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (lineFrequency.containsKey(line)) {
                int frequency = lineFrequency.get(line);
                frequency++;
                lineFrequency.replace(line, frequency);
            } else {
                lineFrequency.put(line, 1);
            }
            if (line.length() > longestLine.length()) {
                longestLine = line;
            }
            countLines++;
        }

        int percentage = (int) (((double) lineFrequency.get(longestLine) / (double)countLines) * 100);
        System.out.println("Total lines: " + countLines + ".\n" +
                "The longest line:\n" + 
                longestLine + "\n" + 
                "(" + lineFrequency.get(longestLine) + " time(s), " + 
                 percentage + "%).");
    }

    private static void readWords() {
        Map<String, Integer> wordFrequency = new Hashtable<>();
        String  longestWord = "";
        int countWords = 0;

        while (scanner.hasNext()) {
            String word = scanner.next();
            if (wordFrequency.containsKey(word)) {
                int frequency = wordFrequency.get(word);
                frequency++;
                wordFrequency.replace(word, frequency);
            } else {
                wordFrequency.put(word, 1);
            }
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
            countWords++;
        }

        int percentage = (int)(((double) wordFrequency.get(longestWord) / (double) countWords) * 100);
        System.out.println("Total words: " + countWords + ".\n" +
                "The longest word: " + longestWord + " (" + wordFrequency.get(longestWord) + " time(s), " + 
                 percentage + "%).");
    }
}
