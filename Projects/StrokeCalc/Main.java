package StrokeCalc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String prim = scan.nextLine();
        calc(prim);
        print(calc(prim));

    }

    static String calc(String prim) throws Exception {
        char action;
        String[] data;

        if (prim.contains(" + ")) {
            data = prim.split(" \\+ ");
            action = '+';
        } else if (prim.contains(" - ")) {
            data = prim.split(" - ");
            action = '-';
        } else if (prim.contains(" * ")) {
            data = prim.split(" \\* ");
            action = '*';
        } else if (prim.contains(" / ")) {
            data = prim.split(" / ");
            action = '/';
        } else {
            throw new Exception("Некорректный знак ввода");
        }

        if (action == '*' || action == '/') {
            if (data[1].contains("\"")) throw new Exception("Строчку необходимо умножать или делить только на число");
        }


        if (!data[0].contains("\"")) throw new Exception("Строка без кавычек");


        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }

        if (data[1].length() > 10) throw new Exception("Количество знаков ввода не более 10");
        if (data[0].length() > 10) throw new Exception("Количество знаков ввода не более 10");


        if (action == '+') {
            return data[0] + data[1];


        } else if (action == '*') {
            int multiplier = Integer.parseInt(data[1]);
            if (multiplier < 1 | multiplier > 10) throw new Exception("Вводимые числа возможны в диапазоне от 1 до 10");
            return data[0].repeat(multiplier);

        } else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if (index == -1) {
                return data[0];
            } else {
                String result = data[0].substring(0, index);
                result += data[0].substring(index + data[1].length());
                return result;

            }
        } else {
            int newLen = data[0].length() / Integer.parseInt(data[1]);
            if (Integer.parseInt(data[1]) < 1 | Integer.parseInt(data[1]) > 10)
                throw new Exception("Вводимые числа возможны в диапазоне от 1 до 10");
            return data[0].substring(0, newLen);
        }
    }

    static void print (String text){
        if (text.length() > 40) {
            String tooLong = text.substring(0, 40);
            System.out.println("\"" + tooLong + "..." + "\"");
        } else {
            System.out.println("\"" + text + "\"");
        }
    }

}






