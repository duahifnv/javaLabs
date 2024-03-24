package utils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

public class TaskManager {
    public static void Run(Class<?> taskList, int taskIndex) {
        try {
            Method task = taskList.getMethod("task" + taskIndex);
            if (task.getParameterCount() > 0) {
                throw new Error(String.format("Для задания %d требуется передать %d аргументов",
                        taskIndex, task.getParameterCount()));
            }
            task.invoke(null);
        }
        catch (Exception NoSuchMethodException) {
            throw new Error("Не существует задания под номером " + taskIndex);
        }
    }
    public static void Run(Class<?> taskList, int taskIndex, List<String> args) {
        try {
            Method task = taskList.getMethod("task" + taskIndex, String[].class);
            task.invoke(null, args.toArray());
        }
        catch (Exception NoSuchMethodException) {
            System.out.println("Не существует задания под номером " + taskIndex);
        }
    }
}
