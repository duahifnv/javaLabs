package task;

import lab5.TaskList;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * <h2>Менеджер заданий для лабораторных работ</h2>
 */
public class TaskManager {
    public static void parse(String... args) {
        String args0;
        try {
            args0 = args[0];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new Error("Не указан номер задачи");
        }
        String[] argsP = Arrays.copyOfRange(args, 1, args.length);
        if (args.length > 1) {
            try {
                int taskIndex = Integer.parseInt(args0);
                TaskBoot.run(TaskList.class, taskIndex, argsP);
            }
            catch (NumberFormatException e) {
                throw new Error("Указан нечисловой аргумент для номера задачи");
            }
            catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                throw new Error("Возникло исключение в задаче", cause);
            }
        }
        else {
            try {
                int taskIndex = Integer.parseInt(args0);
                TaskBoot.run(TaskList.class, taskIndex);
            }
            catch (NumberFormatException e) {
                throw new Error("Указан нечисловой аргумент для номера задачи");
            }
            catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                throw new Error("Возникло исключение в задаче", cause);
            }
        }
    }
}
