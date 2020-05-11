package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the sentence: ");
        try {
            String sentence = ConsoleReader.readSentence();
            List<String> words = Program.getWords(sentence);
            System.out.println("Count of words: " + words.size());
            Program.sort(words);
            System.out.println(words);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
    static class ConsoleReader {
        private static final String REGEX_WORD = "\\w+(-\\w+)|\\w*";
        private static final String REGEX_SENTENCE = "[^.!?;]+[.!?;]*";
        public static String readSentence() {
            Scanner in = new Scanner(System.in);
            String sentence = in.nextLine();
            if (!sentence.matches(REGEX_SENTENCE))
                throw new InputMismatchException("The input does not match regex \"" + REGEX_SENTENCE + "\" (sentence).");
            return sentence;
        }
    }
    static class Program {
        static List<String> getWords(String sentence) {
            ArrayList<String> words = new ArrayList<>();
            Pattern pattern = Pattern.compile("[\\w\\-]+");
            Matcher matcher = pattern.matcher(sentence);
            ArrayList<MatchResult> matches = matcher.results().collect(Collectors.toCollection(ArrayList::new));
            for (MatchResult match : matches) {
                words.add(match.group());
            }
            return words;
        }
        static void sort(List<String> strings) {
            for (int i = 0; i < strings.size(); i++) {
                for (int j = 0; j < strings.size() - 1 - i; j++) {
                    if (strings.get(j).length() > strings.get(j + 1).length()) {
                        String str = strings.get(j);
                        strings.set(j, strings.get(j + 1));
                        strings.set(j + 1, str);
                    }
                }
            }
        }
    }
}
