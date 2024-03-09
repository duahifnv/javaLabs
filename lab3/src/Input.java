import java.util.Scanner;

public class Input {
    public static double Double(double leftB, double rightB, String comm) {
        Scanner scan = new Scanner(System.in);
        double input;
        while (true) {
            System.out.print(comm + ": ");
            try {
                input = scan.nextInt();
                if (input > rightB || input < leftB) {
                    System.out.println("Число находится вне диапазона");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Введено не числовое значение");
                scan.nextLine();
                continue;
            }
            break;
        }
        return input;
    }
}
