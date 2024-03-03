public class Program {
    public static void main(String[] args) throws Exception {
        System.out.println("Лабораторная работа №3");
        try {
            Lab3.t3();
            // Lab3.t2(Integer.valueOf(args[0]), Integer.valueOf(args[1]), Boolean.valueOf(args[2]));
        } catch (Exception e) {
            System.out.println("Заданны непредвиденные параметры");
        }

    }
}
