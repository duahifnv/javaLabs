package lab5.hash.person;

import lab5.hash.Gettable;

/**
 * <h2>Данные о конкретном человеке</h2>
 * @param surname
 * @param name
 * @param age
 */
public record Person(String surname, String name, int age) implements Gettable<String> {
    public String getKey() {
        return surname + name + age;
    }
}
