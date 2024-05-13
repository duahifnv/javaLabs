import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList< Integer > li = new ArrayList< Integer >();
        li.add(1);
        ArrayList< ? > io = li;
        io.add(new Object());
        System.out.println(li.size());
    }
}
interface IA {
    void f();
}
interface IB {
    void f();
}
class A {
    private int a;
    public A(int x) {
        a = x;
        System.out.println("Hello");
    }
}

