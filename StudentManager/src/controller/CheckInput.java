package controller;

import java.util.Scanner;
public class CheckInput {
    public static int checkInputLimit(int min, int max){
        while (true){
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max){
                    throw new NumberFormatException();
                }
                return result;
            }
            catch (NumberFormatException e){
                System.out.println("Please input number again");
            }
        }
    }
    private final static Scanner in = new Scanner(System.in);
    public static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
}
