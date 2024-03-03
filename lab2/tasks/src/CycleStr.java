import java.util.ArrayList;

public class CycleStr extends Utils {
    private ArrayList<String> strokes = new ArrayList<>();
    private String str;
    public CycleStr(String str) {
        this.str = str;
        char[] chars = str.toCharArray();
        if (str.length() < 2) {
            throw new Error("Длина строки должна быть больше 1.");
        }
        String finalstroke;
        if (str.length() == 2) {
            for (int i = 0; i < chars.length; i++) {
                finalstroke = new String(chars);
                this.strokes.add(finalstroke);
                char temp = chars[0];
                chars[0] = chars[1];
                chars[1] = temp;
            }
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            finalstroke = new String(chars);
            this.strokes.add(finalstroke);
            chars = PushRight(chars, i);
        }
    }

    private static char[] PushRight(char[] chars, int index) {
        int len = chars.length;

        int indexFirst = index; // Индекс первого элемента
        int indexSecond = (index + 1 >= len) ? Math.abs(len - index + 1) : index + 1;   // Индекс второго элемента
        char tempFirst = chars[indexSecond];    // Значение элемента, который будет заменен
        char tempSecond;                        // Вспомогательная память
        chars[indexSecond] = chars[indexFirst]; // Замена

        for(int i = 1; i < len; i++) {
            // Исключаем выход за пределы массива
            indexFirst = (index + i >= len) ? Math.abs(len - (index + i)) : index + i;
            indexSecond = (index + i + 1 >= len) ? Math.abs(len - (index + i + 1)) : index + i + 1;
            // Замена с помощью
            tempSecond = chars[indexSecond];
            chars[indexSecond] = tempFirst;
            tempFirst = tempSecond;
        }
        return chars;
    }
    public void PrintCycles() {
        System.out.printf("Циклические перестановки строки %s%n", this.str);
        for (String stroke : this.strokes) {
            System.out.println(stroke);
        }
    }
}
