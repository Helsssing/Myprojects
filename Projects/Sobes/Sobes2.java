package Sobes;

import java.util.Scanner;

public class Sobes2 {
    public static void main (String[]args) {
        Scanner scan = new Scanner(System.in);
        String stroke = scan.nextLine();
        str(stroke);
    }
    private static void str (String args){
        if (args.contains(" ")) {
            String[] data = args.split(" ");
            String word = data[0];
            int multiplier = Integer.parseInt(data[1]);
            String result = word.repeat(multiplier);
            System.out.println(result);
        }

    }

}
