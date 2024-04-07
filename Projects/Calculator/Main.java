package Calculator;

import java.util.Scanner;

public class Main {
    public static void main (String[]args) throws Exception {
        Scanner s = new Scanner(System.in);
        String vvod = s.nextLine();
        calc(vvod);
        System.out.println(calc(vvod));

    }
    public static String calc(String input) throws Exception {
        if (!input.matches("[0-9IVX]+[+*/-][0-9IVX]+")) {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        String operStr = " ";
        char[] symbol = new char[10];
        char oper = ' ';
        for (int i = 0; i < input.length(); i++) {
            symbol[i] = input.charAt(i);
            if (symbol[i] == '+') {
                oper = '+';
                operStr = "\\+";
                break;
            }
            if (symbol[i] == '-') {
                oper = '-';
                operStr = "-";
                break;
            }
            if (symbol[i] == '*') {
                oper = '*';
                operStr = "\\*";
                break;
            }
            if (symbol[i] == '/') {
                oper = '/';
                operStr = "/";
                break;
            }
        }

        int num1;
        int num2;
        String[] numbersStr = input.split(operStr);

        boolean isarabic1 = arabianOrNot(numbersStr[0]);
        boolean isarabic2 = arabianOrNot(numbersStr[1]);
        if (isarabic1 != isarabic2) {
            throw new Exception("Разные системы счисления");
        }

        if (isarabic1) {
            num1 = Integer.parseInt(numbersStr[0]);
            num2 = Integer.parseInt(numbersStr[1]);
        } else {
            num1 = romanNumeral(numbersStr[0]);
            num2 = romanNumeral(numbersStr[1]);
        }

        if (num1 > 10 | num2 > 10 | num1 < 1 | num2 < 1) {
            throw new Exception("Калькулятор умеет работать только с целыми цифрами от 1 до 10 одновременно");
        }

        int cons = calculate(num1, num2, oper);

        if (isarabic1) {
            return String.valueOf(cons);
        } else {
            if (cons < 1){
                throw new Exception("Не существует римских цифр меньше 1(I)");
            } else {
                return romanSolution(cons);
            }
        }
    }
        static int calculate ( int x1, int x2, char op){
            int result = 0;
            switch (op) {
                case '+':
                    result = x1 + x2;
                    break;
                case '-':
                    result = x1 - x2;
                    break;
                case '*':
                    result = x1 * x2;
                    break;
                case '/':
                    result = x1 / x2;
                    break;
                default:
                    break;
            }
            return result;
        }

        static int romanNumeral (String roman){
            return switch (roman) {
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
                default -> 0;
            };
        }

        static boolean arabianOrNot(String numbersStr){
            return !numbersStr.matches("[IVX]+");
        }

        static String romanSolution ( int arabNumeral){
            String[] romanAll = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                    "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                    "*****", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                    "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                    "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                    "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                    "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII",
                    "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
            };
            return romanAll[arabNumeral];
        }
}