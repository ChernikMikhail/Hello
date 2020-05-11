package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        getDescriptionInput();
    }

    public static void getDescriptionInput() {
        int userInput = scanInt(0, Integer.MAX_VALUE);
        String description = " Number " + userInput;
        if (isPrime(userInput)) description += " simple and";
        else if (userInput >= 2) description += " composite and";
        if (isEven(userInput)) description += " even";
        else description += " odd";
        System.out.println(description);
    }

    public static int scanInt(int a, int b) {
        Scanner in = new Scanner (System.in);
        int userInput;
        while (true) {
            System.out.println("Enter an integer " +
                    "in the range [" + a + " .. " + b + "]: ");
            String s = in.nextLine();
            try {
                userInput = Integer.parseInt(s);
                if (userInput < a || userInput > b)
                    System.err.println("Does not match input conditions!");
                else
                    break;
            } catch (NumberFormatException e) {
                System.err.println("Does not match input conditions!");
            }
        }
        in.close();
        return userInput;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static boolean isPrime(int num) {
        if (num < 3) return num == 2;
        if (num % 2 == 0) return false;
        for (int i = num / 3; i >= 3; i -= 2) {
            if (isEven(i)) i--;
            if ((num % i) == 0)
                return false;
        }
        return true;
    }
}
