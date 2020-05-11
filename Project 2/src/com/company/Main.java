package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two integers: ");

        try {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.printf("\nGreatest Common Divisor: %d;\nLeast Common Multiple: %d.", Main.Program.gcd(a, b), Main.Program.lcm(a, b));
        } catch (InputMismatchException var4) {
            System.out.println("Invalid input.");
        } catch (IllegalArgumentException var5) {
            System.out.println(var5.getMessage());
        }

    }

    static class Program {
        Program() {
        }

        static int gcd(int a, int b) {
            if (a == 0 && b == 0) {
                throw new IllegalArgumentException("lcm(a ,b). Parameters a and b are equals to zero.");
            } else {
                return b == 0 ? a : gcd(b, a % b);
            }
        }

        static int lcm(int a, int b) {
            if (a == 0 && b == 0) {
                throw new IllegalArgumentException("lcm(a ,b). Parameters a and b are equals to zero.");
            } else {
                return a / gcd(a, b) * b;
            }
        }
    }
}
