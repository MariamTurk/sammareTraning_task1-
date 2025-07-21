package taskes;

public class StringTasks {

    public static void main(String[] args) {

        // 1. Test customSplit
        String test = "mariam,noura,sama";
        String[] result = customSplit(test, ',');
        System.out.println("Result of customSplit:");
        for (int i = 0; i < result.length; i++) {
            System.out.println("word " + (i + 1) + " = " + result[i]);
        }

        // 2. Test countChar
        System.out.println("\nResult of countChar:");
        String sample = "MAriam Turk";

        System.out.println("Input-> \"" + sample + "\"");

        System.out.println("Ignore case (m): " + countChar(sample, 'm', true));     // Expected: 4 (counts l and L)
        System.out.println("Case sensitive (m): " + countChar(sample, 'm', false)); // Expected: 2
        System.out.println("Case sensitive (T): " + countChar(sample, 'T', false)); // Expected: 2
        System.out.println("Case sensitive (n): " + countChar(sample, 'n', false)); // Expected: 0

        // 3. Test reverseWords
        System.out.println("\nResult of reverseWords:");
        String original = "Java is very fun";
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reverseWords(original)); // Expected: "fun very is Java"
    }

    // 1. Splits a string by a specific character (without using split())
    public static String[] customSplit(String str, char delimiter) {
        if (str == null || str.isEmpty())
            return new String[0];

        // Count how many parts we will have
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == delimiter)
                count++;
        }

        String[] parts = new String[count];
        int partIndex = 0;
        int start = 0;

        // Extract substrings manually
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == delimiter) {
                parts[partIndex++] = str.substring(start, i);
                start = i + 1;
            }
        }

        // Add the last part
        parts[partIndex] = str.substring(start);
        return parts;
    }

    // 2. Counts how many times a character appears, with or without ignoring case
    public static int countChar(String str, char ch, boolean ignoreCase) {
        if (str == null)
            return 0;

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (ignoreCase) {
                if (Character.toLowerCase(current) == Character.toLowerCase(ch))
                    count++;
            } else {
                if (current == ch)
                    count++;
            }
        }
        return count;
    }

    // 3. Reverses the order of words in a sentence (no reversing characters inside words)
    public static String reverseWords(String sentence) {
        if (sentence == null || sentence.isEmpty())
            return sentence;

        int len = sentence.length();
        String[] words = new String[100]; // Max 100 words
        int wordCount = 0;
        int start = 0;

        // Manually extract words without using split()
        for (int i = 0; i <= len; i++) {
            if (i == len || sentence.charAt(i) == ' ') {
                words[wordCount++] = sentence.substring(start, i);
                start = i + 1;
            }
        }

        //  reversed sentence
        StringBuilder sb = new StringBuilder();
        for (int i = wordCount - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0)
                sb.append(' ');
        }

        return sb.toString();
    }
}
