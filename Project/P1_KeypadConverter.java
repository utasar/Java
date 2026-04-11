import java.util.Scanner;

public class P1_KeypadConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter word: ");
        String word = input.next();

        while (!word.matches("[A-Za-z]+")) {
            System.out.println("Invalid input. Please only enter letters.");
            word = input.next();
        }
        input.close();
        
        String uppercaseWord = word.toUpperCase();
        for (int i = 0; i < uppercaseWord.length(); i++) {
            System.out.print(getNumberSwitch(uppercaseWord.charAt(i)));
        }
    }

    public static int getNumberSwitch(char letter) {
        switch (letter) {
            case 'A':
            case 'B':
            case 'C':
                return 2;
            case 'D':
            case 'E':
            case 'F':
                return 3;
            case 'G':
            case 'H':
            case 'I':
                return 4;
            case 'J':
            case 'K':
            case 'L':
                return 5;
            case 'M':
            case 'N':
            case 'O':
                return 6;
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
                return 7;
            case 'T':
            case 'U':
            case 'V':
                return 8;
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                return 9;
            default:
                return 0;
        }
    }

    public static int getNumber(char letter) {
        if (letter == 'A' || letter == 'B' || letter == 'C') {
            return 2;
        } else if (letter == 'D' || letter == 'E' || letter == 'F') {
            return 3;
        } else if (letter == 'G' || letter == 'H' || letter == 'I') {
            return 4;
        } else if (letter == 'J' || letter == 'K' || letter == 'L') {
            return 5;
        } else if (letter == 'M' || letter == 'N' || letter == 'O') {
            return 6;
        } else if (letter == 'P' || letter == 'Q' || letter == 'R' || letter == 'S') {
            return 7;
        } else if (letter == 'T' || letter == 'U' || letter == 'V') {
            return 8;
        } else if (letter == 'W' || letter == 'X' || letter == 'Y' || letter == 'Z') {
            return 9;
        } else {
            return 0;
        }
    }
}
