package lab5.coin;

import java.util.ArrayList;
import java.util.Arrays;
import lab5.dlist.DList;

/**
 * <h2>Автомат выдачи монет</h2>
 * <h3>Динамическое программирование</h3>
 */
public class CoinMachine {
    private DList<Integer, Integer> machine;
    public CoinMachine(String label) {
        this.machine = new DList<>(label);
    }
    public void addData(int[] coins, int total) {
        machine.add(total, minCoins(coins, total));
    }
    public Integer[] getData(Integer total) {
        return machine.get(total).toArray(new Integer[0]);
    }
    // Алгоритм нахождения минимального числа монет
    private static ArrayList<Integer> minCoins(int[] coins, int total) {
        Arrays.sort(coins);
        ArrayList<Integer> minCoins = new ArrayList<>();
        // Идем от самых больших до самых маленьких номиналов
        for (int i = coins.length - 1; i >= 0 && total > 0; i--) {
            // Пока сумма не меньше цены монеты отнимаем цену монеты от стоимости
            while (total >= coins[i]) {
                total -= coins[i];
                minCoins.add(coins[i]);     // Добавляем
            }
        }
        return minCoins;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Integer total : machine.keys()) {
           result.append("Минимальный набор монет для ").append(total)
                   .append(" рублей: ").append(machine.get(total)).append("\n");
        }
        return result.toString();
    }
}
