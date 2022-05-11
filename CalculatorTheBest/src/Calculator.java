import java.util.Scanner;

public class Calculator {

    static Scanner in = new Scanner(System.in);
    static int firstSign, secondSign, sum;
    static char operation;


    static int calculated(int num1, int num2, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println("Результат сложения: ");
                break;
            case '-':
                result = num1 - num2;
                System.out.println("Результат вычитания: ");
                break;
            case '*':
                result = num1 * num2;
                System.out.println("Результат умножения: ");
                break;
            case '/':
                result = num1 / num2;
                System.out.println("Результат деления: ");
                break;

        }
        return result;
    }

    static int romToArab(String romNum) {
        return switch (romNum) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -1;
        };
    }
    static String convertArabToRom(int numArab) {
        String[] rom = new String[]{
                "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };

        return rom[numArab - 1];
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Введите ваш пример: ");
        String primer = in.nextLine();

        char[] charArr = new char[15];
        for (int i = 0; i < primer.length(); i++) {
            charArr[i] = primer.charAt(i);
            if (charArr[i] == '+') {
                operation = '+';
            }
            if (charArr[i] == '-') {
                operation = '-';
            }
            if (charArr[i] == '*') {
                operation = '*';
            }
            if (charArr[i] == '/') {
                operation = '/';
            }
        }


        String massCharString = String.valueOf(charArr);
        String[] stringArray = massCharString.split("[+-/*]");

        if (stringArray.length < 2) {
            throw new Exception("Не верное выражение");
        }
        if (stringArray.length > 2) {
            throw new Exception("Не верно, введите два операнда и один оператор (+, -, *, /)");
        }


        String left = stringArray[0].trim();
        String right = stringArray[1].trim();


        firstSign = romToArab(left);
        secondSign = romToArab(right);

        if (firstSign == -1 && secondSign > -1 || secondSign == -1 && firstSign > -1) {
            throw new Exception("Используются одновременно разные системы счисления (введите только арабские или только римские цифры) или введено римское число больше X");
        }

        if (firstSign < 0 && secondSign < 0) {
            sum = 0;

        } else {
            sum = calculated(firstSign, secondSign, operation);
            if (sum < 0 || sum == 0) {
                throw new Exception("Ноль и отрицательные числа отсутствуют в римской системе исчисления");
            }
            String resultRoman = convertArabToRom(sum);
            System.out.println(resultRoman);
            return;
        }

        try {
            firstSign = Integer.parseInt(left);
            secondSign = Integer.parseInt(right);
        } catch (NumberFormatException e) {
            throw new Exception("Неверный формат. Введите римскую или арабскую цифру от 1 до 10");
        }


        if ((firstSign < 1) || (firstSign > 10) || (secondSign < 1) || (secondSign > 10)) {
            throw new Exception("Введено число вне диапазона значения. Допускается ввод цифр от 1 до 10");

        } else {
            sum = calculated(firstSign, secondSign, operation);
            System.out.println(sum);
        }

    }

}

