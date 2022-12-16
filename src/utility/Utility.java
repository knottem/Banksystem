package utility;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility {

    public int inputInt(String text) {
        while (true) {
            Scanner scan;
            System.out.println(text);
            try {
                scan = new Scanner(System.in);
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Förväntade mig ett nummer");
            } catch (NumberFormatException e) {
                System.out.println("Inte nummer");
            }
            return 0;
        }
    }

    public boolean repeatProgram(String text) {
        boolean repeat;
        do {
            System.out.println(text +" j/n");
            Scanner input = new Scanner(System.in);
            String yesNo = input.nextLine();
            repeat = true;
            switch (yesNo) {
                case "j" -> repeat = false;
                case "n" -> {
                    System.out.println("Hej då");
                    System.exit(0);
                    }
                default -> System.out.println("Svara med j för JA och n för NEJ");
            }
        } while (repeat);
        return false;
    }

    public void sleep(int number){
        try{
            Thread.sleep(number);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
