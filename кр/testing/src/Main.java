import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList< Integer > li = new ArrayList<>();
        li.add(1);
        ArrayList< ? > io = li;
        io.add(new Object());
        System.out.println(li.size());
    }
}
interface I1 {}
interface I2 {}
class A {}
class B<T extends A implements I1, I2> {}
class B1<T extends A & I1 & I2> {}
class B2<T extends A, I1, I2> {}