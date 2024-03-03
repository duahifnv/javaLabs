public class Program {
    public static void main(String[] args) throws Exception {
        System.out.println("Лабораторная работа #2");
        if (args.length == 0)  throw new Error("Введен пустой аргумент!");
        if (!Character.isDigit(args[0].charAt(0))) throw new Error("Введен нечисловой аргумент!");
        TaskMng.Task5(Integer.valueOf(args[0]));
    }
}
