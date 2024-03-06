import java.util.Arrays;

public class Program {
    public static void main(String[] args) throws Exception {
        int labId = 1;
        try {
            labId = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("Заданы непредвиденные параметры");
            System.exit(-1);
        }
        System.out.println("Лабораторная работа №3");
        System.out.println("Задача №" + String.valueOf(labId));
        switch (labId) {
            case 1:
            Lab3.t1();
            break;
            case 2:
            Lab3.t2(Integer.valueOf(args[1]), Integer.valueOf(args[2]), Boolean.valueOf(args[3]));
            break;
            case 3:
            Lab3.t3();
            break;
            case 4:
            Lab3.t4();
            break;
            case 5:
            Lab3.t5();
            break;
            case 6:
            Lab3.t6();
            break;
            case 7:
            // Lab3.t7();
            break;
            default:
            System.out.println("Неверный номер задачи");
        }
    }
}
