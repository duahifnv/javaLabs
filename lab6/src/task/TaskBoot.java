package task;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;

/**
 * <h2>Исполнитель заданий для лабораторных работ</h2>
 */
public class TaskBoot {
    public static void run(Class<?> taskList, int taskIndex) throws InvocationTargetException {
        Method[] tasks = taskList.getDeclaredMethods();
        for (Method m : tasks) {
            if (m.getName().contains("task" + taskIndex)) {
                if (m.getParameterCount() > 0) {
                    throw new Error(String.format("Для задания %d требуется передать %d аргумента(-ов)",
                            taskIndex, m.getParameterCount()));
                }
                try {
                    m.invoke(null);
                }
                catch (IllegalAccessException e) {
                    throw new Error("Нет доступа к указанной задаче");
                }
                return;
            }
        }
        throw new NoSuchElementException("Не существует задания под номером " + taskIndex);
    }
    public static void run(Class<?> taskList, int taskIndex, String[] args) throws InvocationTargetException {
        Method[] tasks = taskList.getDeclaredMethods();
        for (Method m : tasks) {
            if (m.getName().contains("task" + taskIndex)) {
                if (m.getParameterCount() != args.length) {
                    throw new Error("Количество параметров не совпадает с требуемым в задаче");
                }
                try {
                    m.invoke(null, (Object[]) args);
                }
                catch (IllegalArgumentException e) {
                    throw new Error("Задача должна принимать строковые аргументы");
                }
                catch (IllegalAccessException e) {
                    throw new Error("Нет доступа к указанной задаче");
                }
                return;
            }
        }
        throw new NoSuchElementException("Не существует задания под номером " + taskIndex);
    }
}
