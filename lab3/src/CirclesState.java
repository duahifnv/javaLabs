public class CirclesState {
    private enum State {
        NODOT("НЕТ ПЕРЕСЕЧЕНИЙ"),
        ONEDOT("ОДНО ПЕРЕСЕЧЕНИЕ"),
        TWODOTS("ДВА ПЕРЕСЕЧЕНИЯ"),
        OVERLAP("СОВПАДЕНИЕ"),
        NESTEDFIRST("ПЕРВАЯ ВЛОЖЕНА ВО ВТОРУЮ"),
        NESTEDSECOND("ВТОРАЯ ВЛОЖЕНА В ПЕРВУЮ");

        private String value;
        State(String value) {
            this.value = value;
        }
    }

    private static State state;
    public static void SolveState(int x1, int y1, int r1, int x2, int y2, int r2) {
        double dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));   // Расстояние между центрами окружностей
        // Проверка на вложенность
        if (r1 != r2 && dist + Math.min(r1, r2) < Math.max(r1, r2)) {
            state = (r1 < r2) ? State.NESTEDFIRST : State.NESTEDSECOND;
            return;
        }

        if (dist == r1 + r2 || ((r1 != r2) && dist == Math.max(r1, r2) - Math.min(r1, r2))) state = State.ONEDOT; // Касание снаружи или изнутри
        else if (dist == 0) state = State.OVERLAP;
        else if (dist > r1 + r2) state = State.NODOT;
        else state = State.TWODOTS;
    }

    public static String GetState() {
        try {
            return state.value;
        } catch (Exception e) {
            return "N/A";
        }
    }

    public static int GetCode() {
        try {
            return state.ordinal();
        }
        catch (Exception e) {
            return -1;
        }
    }
}
