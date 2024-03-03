import java.util.HashMap;
import java.util.Map;

public class CharFinder extends Utils {
    private final String[] groups = {"Letters", "LowerCase", "UpperCase", "Digits", "ArabicD", "RomanD", "Others", "Overall"};
    private Map<String, Integer> counter = new HashMap<>();
    private String str;

    public CharFinder(String str) {
        this.str = str;
        System.out.println("Подсчет символов в строке: " + this.str);
        InitMap();
    }

    private void InitMap() {
        for (String group : groups) {
            this.counter.put(group, 0);
        }
    }

    private void IncKey(String key) {
        this.counter.put(key, this.counter.get(key) + 1);
    }

    public void FindStat() {
        String romans = "IVXLCM";
        for (char ch : this.str.toCharArray()) {
            if(Character.isLetter(ch)) {
                IncKey("Letters");
                if(Character.isUpperCase(ch)) {
                    IncKey("UpperCase");
                    if (romans.indexOf(ch) != -1) {
                        IncKey("RomanD");
                        IncKey("Digits");
                    }
                }
                else
                    IncKey("LowerCase");
            }
            else if(Character.isDigit(ch)) {
                IncKey("Digits");
                IncKey("ArabicD");
            }
            else IncKey("Others");
        }
        this.counter.put("Overall", str.length());
    }

    public void PrintStat() {
        System.out.printf("%15s| %-20s%n", "Тип символа", "Число вхождений");
        for(String key : counter.keySet()) {
            System.out.printf("%15s|%3d%n", key, counter.get(key));
        }
    }


}
