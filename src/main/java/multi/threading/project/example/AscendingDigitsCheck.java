package multi.threading.project.example;

import java.util.ArrayList;

public class AscendingDigitsCheck {
    public static void main(String[] args) {
        int startRange = 1000;
        int endRange = 13000;

        ArrayList<Integer> result = findAscendingNumbers(startRange, endRange);

        if (!result.isEmpty()) {
            System.out.println("Numbers in the range [" + startRange + ", " + endRange + "] with ascending digits by 1:");
            for (int num : result) {
                System.out.println(num);
            }
        } else {
            System.out.println("No numbers found in the range [" + startRange + ", " + endRange + "] with ascending digits by 1.");
        }
    }

    // Function to find numbers with ascending digits by 1 in a given range
    static ArrayList<Integer> findAscendingNumbers(int startRange, int endRange) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = startRange; i <= endRange; i++) {
            if (hasAscendingDigits(i)) {
                result.add(i);
            }
        }

        return result;
    }

    // Function to check if the digits of a number are in ascending order by 1
    static boolean hasAscendingDigits(int number) {
        String numString = Integer.toString(number);

        for (int i = 0; i < numString.length() - 1; i++) {
            if (numString.charAt(i + 1) - numString.charAt(i) != 1) {
                return false; // If the difference is not 1, digits are not in ascending order by 1
            }
        }

        return true; // All digits are in ascending order by 1
    }


}
