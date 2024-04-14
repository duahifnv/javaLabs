package lab5.cup;

import lab5.Pair;
import lab5.bag.Bag;
import lab5.bag.GenericPairBag;
import java.util.Scanner;

/**
 * <h2>Турнир</h2>
 * <h3>Игра на вылет (без лузерной сетки)</h3>
 */
public class Cup {
    private final int membersCount;
    public Cup (int membersCount) {
        if (!isPowerOfTwo(membersCount) || membersCount < 4) {
            System.out.println("Указано неверное число игроков");
            int DEFAULT_SIZE = 8;
            System.out.println("Значение по умолчанию: " + DEFAULT_SIZE);
            this.membersCount = DEFAULT_SIZE;
        }
        else {
            this.membersCount = membersCount;
        }
    }
    public void run() {
        System.out.println("**Турнир**");
        Bag teams = new Bag(membersCount);
        for (int i = 1; i <= membersCount; i++) {
            teams.putItem("Команда " + i);
        }
        GenericPairBag<String, String> rivals = new GenericPairBag<>(membersCount / 2);
        int tourId = 1;
        while (teams.getWeight() != 1) {
            System.out.println("Тур " + tourId++);
            int size = teams.getWeight();
            // Составляем тур
            for (int i = 0; i < size / 2; i++) {
                rivals.put(new Pair<>(teams.pickItem().toString(), teams.pickItem().toString()));
            }
            Bag winners = new Bag(size / 2);
            // Ищем победителей
            while (!rivals.isEmpty()) {
                Pair<String, String> rival = rivals.pick();
                String winner = playRival(rival);
                winners.putItem(winner);
            }
            teams = winners;
        }
        String winner = teams.pickItem().toString();
        System.out.println("Победила " + winner);
    }
    // Провести один матч
    private String playRival(Pair<String, String> rival) {
        System.out.println(rival.first + " | " + rival.second);
        System.out.printf("Кто выйграл?%n0, если первая команда%n1, если вторая команда%n");
        Scanner scan = new Scanner(System.in);
        String win = scan.nextLine();
        if (win.equals("exit")) System.exit(0);
        if (win.equals("0")) return rival.first;
        else return rival.second;
    }
    // Проверка на степень двойки
    private static boolean isPowerOfTwo(int n) {
        return (int)(Math.ceil((Math.log(n) / Math.log(2))))
                == (int)(Math.floor(((Math.log(n) / Math.log(2)))));
    }
}
