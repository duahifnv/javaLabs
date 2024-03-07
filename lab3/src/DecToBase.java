public class DecToBase {
    public static int ConvertTo(int dec, int base) {
        if (dec < 0) {
            System.out.println("Число должно быть больше или равно 0");
            return -1;
        }
        if(dec == 0) return 0;
        String result = "";
        while (dec > 0) {
            result = String.valueOf(dec % base) + result;
            dec /= base;
        }
        return Integer.valueOf(result);
    }
}