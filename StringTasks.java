package taskes;

import java.util.Scanner;

public class StringTasks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Test customSplit
        System.out.println("enter a string to split it:");
        String test = scanner.nextLine();
        System.out.println("enter the delimiter character:");
        char delimiter = scanner.nextLine().charAt(0);

        String[] result = customSplit(test, delimiter);
        System.out.println("result of customSplit:");
        for (int i = 0; i < result.length; i++) {
            System.out.println("Word " + (i + 1) + " = " + result[i]);
        }

        // 2. Test countChar
        System.out.println("\nenter a string to count characters from:");
        String sample = scanner.nextLine();

        System.out.println("enter the character to count:");
        char ch = scanner.nextLine().charAt(0);

        System.out.println("ignore case? (true/false):");
        String choice = scanner.nextLine();
        boolean ignoreCase = choice.equals("true");

        int count = countChar(sample, ch, ignoreCase);
        System.out.println("character count: " + count);

        // 3. Test reverseWords
        System.out.println("\nenter a sentence to reverse it:");
        String original = scanner.nextLine();

        String reversed = reverseWords(original);
        System.out.println("reversed sentence: " + reversed);

        scanner.close();
    }

    // splits a string by a specific character
    public static String[] customSplit(String str, char delimiter) {
        // if the str is null
        if (str == null || str.length() == 0)
            return new String[0];
        // this to know how any part i will split    
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == delimiter)
                count++;
        }
        // inital array to put the part in it 
        String[] parts = new String[count];
        int partIndex = 0;
        int start = 0;
        // loop to find the delim and split the words in the aaray 
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == delimiter) {
                parts[partIndex++] = manualSubstring(str, start, i);
                start = i + 1;
            }
        }
        // this for the final word in the array
        parts[partIndex] = manualSubstring(str, start, str.length());
        return parts;
    }

    // counts how many character appears with or without ignoring case
    public static int countChar(String str, char ch, boolean ignoreCase) {
        if (str == null)
            return 0;

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            // here to ignore the case 
            if (ignoreCase) {
                if (manualToLower(current) == manualToLower(ch))
                    count++;
            }
            // not ignor the case 
             else {
                if (current == ch)
                    count++;
            }
        }
        return count;
    }

    // reverses the order of words in sentence 
    public static String reverseWords(String sentence) {
        if (sentence == null || sentence.length() == 0)
            return sentence;

        int len = sentence.length();
        String[] words = new String[100];
        int wordCount = 0;
        int start = 0;
        // to know the words we have 
        for (int i = 0; i <= len; i++) {
            if (i == len || sentence.charAt(i) == ' ') {
                words[wordCount++] = manualSubstring(sentence, start, i);
                start = i + 1;
            }
        }
        // revers the words in this loop 
        StringBuilder sb = new StringBuilder();
        for (int i = wordCount - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0)
                sb.append(' ');
        }

        return sb.toString();
    }

    // fun to extract substring manually
    public static String manualSubstring(String str, int start, int end) {
        char[] chars = new char[end - start];
        for (int i = start; i < end; i++) {
            chars[i - start] = str.charAt(i);
        }
        return new String(chars);
    }

    // convert character to lowercase by ascii
    public static char manualToLower(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32);
        }
        return c;
    }
}
