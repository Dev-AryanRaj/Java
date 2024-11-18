import java.util.ArrayList;     //Importing the whole util package
import java.util.List;
import java.util.Scanner;

public class LetterMapping {

    private static final String[] LETTER_MAP = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    //The index 0 and 1 are left blank as the letters correspond from digits 2-9

    public static List<String> LetterCombos(String digits) {
        List<String> combinations = new ArrayList<>();      //Array thats dynamic(ArrayList is a class in util library)
        if (digits.isEmpty()) {
            return combinations;    //Means whenever theres no more digits left it returns the combination
        }

        backtrack(digits, 0, new StringBuilder(), combinations);     //Calls the recurssive backtrack function
        return combinations;
    }

    private static void backtrack(String digits, int index, StringBuilder current, List<String> combinations) {       //new StringBuilder with variable name current
        if (index == digits.length()) {      //Checks if the current index has reached the end of the string "digits"
            combinations.add(current.toString());       //Here, the StringBuilder "current" is converted into string and is added to the "combinations".
            return;
        }

        int digit = Character.getNumericValue(digits.charAt(index));   //Gets the digit at the given index in numeric type value and stores as int type
        if (digit < 2 || digit > 9) {
            return;
        }

        String letters = LETTER_MAP[digit];     //The digit here is the index for the LETTER_MAP and is used to get the correwspoding string of letters

        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(digits, index + 1, current, combinations);    //recursion with the backtrack function with index + 1 to move to the next digit
            current.deleteCharAt(current.length() - 1);      //Explores all possibilities for the cuirrent digit by deleting the appended letter from the current StringBuilder
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string of digits (2-9): ");
        String digits = scanner.nextLine();

        while (!isValidInput(digits)) {      //now the "false" return that we get from the function will make the while loop execute untill the user enters the right values(between 2-9)
            System.out.println("Invalid input. Please enter digits from 2-9 only.");
            System.out.print("Enter a string of digits (2-9): ");
            digits = scanner.nextLine();
        }

        List<String> combinations = LetterCombos(digits);        //The "LetterCombos" finally returns and stores all the possible combinations into the variable "combinations"
        System.out.println("Possible letter combinations: " + combinations);     //Print it and done !

        scanner.close();
    }

    private static boolean isValidInput(String digits) {
        for (char c : digits.toCharArray()) {
            if (c < '2' || c > '9') {   //"False" returned if values not between 2-9
                return false;
            }
        }
        return true;
    }
}