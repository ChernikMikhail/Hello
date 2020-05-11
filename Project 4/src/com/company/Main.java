package com.company;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Enter the text: ");
            String text = ConsoleReader.readText();
            System.out.println("Enter the word: ");
            String word = ConsoleReader.readWord();
            System.out.printf("The word \"%s\" occurs in the text %d times", word, Program.getWordCount(text, word));
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
    static class ConsoleReader {
        private static final String REGEX_WORD = "\\w+(-\\w+)|\\w*";
        private static final String REGEX_SENTENCE = "[^.!?;]+[.!?;]*";
        //Input Mismatch Exception
        public static String readWord() {
            Scanner in = new Scanner(System.in);
            String word = in.nextLine();
            if (!word.matches(REGEX_WORD))
                throw new InputMismatchException("The input does not match regex \"" + REGEX_WORD + "\" (word).");
            return word;
        }
        public static String readText() {
            Scanner in = new Scanner(System.in);
            StringBuilder builder = new StringBuilder();
            String token;
            while (true) {
                token = in.nextLine();
                if (token.equals("")) {
                    return builder.toString();
                }
                builder.append(token).append('\n');
            }
        }
    }
    static class Program {
        //Not case sensitive
        static int getWordCount(String text, String word) {
            if (word.equals("") || text.equals("")) throw new IllegalArgumentException("Invalid input");
            text = text.toLowerCase();
            word = word.toLowerCase();
            int wordCount = 0;
            Matcher matcher = Pattern.compile("\\b" + word + "\\b").matcher(text);
            while (matcher.find()) {
                wordCount++;
            }
            return wordCount;
        }
    }
}

